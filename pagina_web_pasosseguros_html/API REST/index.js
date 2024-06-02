
const express = require('express'); // Se importa el paquete
const bodyParser = require('body-parser');
const app = express();
const port = 10000;

//Llamamos al bodyParser para la estructura Json
app.use(bodyParser.json());

//Importamos las rutas
const crudRoute = require('./routes/crud');
const authRoute = require('./routes/authentication');

app.use('/api', crudRoute);
app.use('/auth', authRoute);

app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
}); 

//***************************************************************************************** */
/* SE CREAN RUTAS
app.get('/', (req, res) => {
    res.send('Bienvenido a la API REST'); // Se verifica que este funcionando la API
});

//Ruta pata mostrar todos los clientes
app.get('/cliente', (req, res) => {
    const sql = 'SELECT * FROM cliente'; //Sentencia SQL para mostrar clientes
    db.query(sql, (err, result) => {
        if(err) {
            throw err;
        }
        res.json(result)
    });
});

//Crear un usuario nuevo
app.post('/cliente', (req, res) =>{
    const nuevoCliente = req.body;
    const sql = 'INSERT INTO cliente SET ?';
    db.query(sql,nuevoCliente, (err, result) => {
        if(err){
            throw err;
        }
        console.log('Se ha registrado correctamente!');
    });
});

//Actualiza el usuario

app.put('/cliente/:IDPERSONA', (req, res) => {
    const {IDPERSONA} = req.params;
    const update = req.body;
    const sql = 'UPDATE cliente SET ? WHERE IDPERSONA = ?';
    db.query(sql, [update, IDPERSONA], (err, result) =>{
        if(err){
            throw err;
        }
        console.log('Se actualizo con exito!');
    });
});

//Eliminar un Usuario
app.delete('/cliente/:IDPEROSNA', (req, res) =>{
    const {IDPERSONA} = req.params;
    const sql = "DELETE FROM cliente WHERE IDPERSONA = ?";
    db.query(sql, IDPERSONA, (err, result) =>{
        if(err){
            throw err;
        }
        console.log('Se elimino correctamente el ' + IDPERSONA);
    });
}); */

//se configura como se va a escuchar el servidor las peticiones
