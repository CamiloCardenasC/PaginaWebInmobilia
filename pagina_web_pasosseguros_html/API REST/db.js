/** CONEXION A LA DB MYSQL */
const mysql = require('mysql');//Se importa el Paquete MySQL para la conexion a mi base de datos

//Se configura la BD
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'bd_prueba_api'
});

//Se conecta la BD
db.connect(err => {
    if(err){
        throw err
    }
    console.log('La conexión a la Base de Datos ha sido exitosa!');
});

module.exports = db;