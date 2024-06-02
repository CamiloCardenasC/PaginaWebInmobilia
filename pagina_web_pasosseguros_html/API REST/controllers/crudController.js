
const db = require('../db');// Importo la configuracion de la base de datos
const bcrypt = require('bcrypt');

/**RUTA PARA VER LOS CLIENTES */
exports.getClientes = (req, res) => {
    //Escribo la sentencia sql para mostrar todos los clientes
    const sql = 'SELECT * FROM cliente';

    /* Ingreso a la base de datos donde me va a mostrar dos opciones, 
    'err' si no se pudo acceder a la base de datos y result si logro obtener los datos requeridos*/ 
    db.query(sql, (err, result) =>{
        if(err){
            return res.status(500),send('Error en la Base de Datos!');
        }
        res.json(result);
    });
};

/** CREACION DE UN USUARIO */
exports.addCliente = (req, res) => {
    //Traemos los datos del formulario
    const {nombrePersona,apellidosPersona,fechaNacimiento,telefono,correoElectronico,contraseña} = req.body;

    //Encriptamos la contraseña antes de guardarse en la DB
    bcrypt.hash(contraseña, 10 , (err, hash) =>{
        if(err){
            res.status(500).send('Error al encriptar la contraeña');
        }
        
        //Creamos un objeto con los datos ingreados
        const nuevaPersona = {nombrePersona,apellidosPersona,fechaNacimiento,telefono,correoElectronico,contraseña:hash};
        const sqlNuevaPersona = 'INSERT INTO persona SET ?'; //Sentencia SQL para ingresar datos a la tabla

        //Ingresamos a la base de datos donde se va a crear la persona
        db.query(sqlNuevaPersona, nuevaPersona, (err, result) => {
            if(err){
                return res.status(500).send('Error al ingresar datos a persona');
            }

            //Se va a crear automaticamente el ID
            const idPersona = result.insertId;
            const nuevoCliente = {IdPersona:idPersona}; //El cliente va a heredar los datos de la persona

            //Se crea un nuevo Cliente
            const sqlnuevoCliente = "INSERT INTO cliente SET ?";//Se genera una sentencia para guardar los datos
            db.query(sqlnuevoCliente, nuevoCliente, (err, result) => {
                if(err){
                    return res.status(500).send('Error al crear nuevo Cliente');
                }

                //Al crearse un Cliente automaticamente se crea un usuario
                const nuevoUsuario = {correoElectronico: correoElectronico, password: contraseña,
                    fechaRegistro: new Date() //Se genera fecha actual
                };
                const sqlNuevoUsuario = 'INSERT INTO usuario SET ?';
                db.query(sqlNuevoUsuario, nuevoUsuario, (err, result) => {
                    if(err){
                        return res.status(500).send('Error al crear Usuario');
                    }
                    res.send('Se creo el Usuario con exíto!');
                });
            });
        });
    });
};

/** ACTUALIZAR UN CLIENTE */
exports.updateCliente = (req, res) => {
    const { id } = req.params; //Se toma el ID de la persona que se quiere actualizar
    const {nombreUsuario,apellidoUsuario,fechaNacimiento,telefono,correoElectronico} = req.body; //Se preparan los datos para actualizar
    const sql = 'UPDATE persona INNER JOIN cliente ON persona.idPersona = cliente.idPersona SET ? WHERE cliente.idCliente = ?';
    const updatedData = {nombreUsuario,apellidoUsuario,fechaNacimiento,telefono,correoElectronico}; //Se guardan los datos que se actualizaron

    //Se ejecuta la consulta en la base de datos
    db.query(sql, [updatedData, id], (err, result) => {
        if(err){
            return res.status(500).send('Error al actualizar el cliente');
        }
        res.send('El cliente se actualizo con exito!');
    });
};

/** ELIMINAR CLIENTE */
exports.deleteCliente = (req, res) => {
    const {id} = req.params; //Se toma el ID de la persona que se quiere eliminar
    const sql = 'DELETE persona, cliente FROM persona INNER JOIN cliente ON persona.idPersona = cliente.idPersona WHERE cliente.idCliente = ?';

    //Se ejecuta la consulta SQL para eliminar la Persona 
    db.query(sql, [id], (err, result) => {
        if(err){
            return res.status(500).send('Error al eliminar el Cliente');
        }
        res.send('El cliente se elimino con exito!');
    });
};