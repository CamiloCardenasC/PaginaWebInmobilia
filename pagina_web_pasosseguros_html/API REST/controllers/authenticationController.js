//Importamos la BD
const db = require('../db');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

/** AUTENTICACION USUARIO */
exports.login = (req, res) => {

    //Se Obtiene los datos de usuario del Cliente
    const {emailUsuario, password} = req.body;
    const sql = 'SELECT * FROM usuario WHERE nombreUsuario = ?'; //Sentencia para buscar en la DB MySQL

    //Se Ejecuta la consulta SQL para buscar el la DB el correo Electronico del Usuario
    db.query(sql, [emailUsuario], (err, results) => {
        if(err){
            return res.status(500).send('Error en la base de datos!.');
        }
        //Se generara un error si no se encuentra el correo Electronico en la base de datos, se lo contrario seguira ejecutandose 
        if(results.length === 0){
            return res.status(404).send('Usurio no encontrado');
        }
        //Se guarda el usuario encontrado
        const usuarioEncontrado = results[0];
        //Se compara la contraseña empriptada con la que envio el cliente
        bcrypt.compare(password, usuarioEncontrado.password, (err, isMatch) =>{
            if(err){
                return res.status(500).send('Error al comparar la contraseña');
            }
            //Si no coinciden enviara un mensaje de error
            if(!isMatch){
                return res.status(401).send('La contraseña no coincide');
            }
            const token = jwt.sign({ id: user.id }, 'tu_secreto', { expiresIn: '1h' });
            res.json({ token });
            // de lo contraio se validara con exito la autenticacion
            res.send('Autenticacion Exitosa!');

        });

    });

};