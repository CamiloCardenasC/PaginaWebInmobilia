const express = require('express');
const router = express.Router();
const crudController = require('../controllers/crudController');

//Definimos la Rutas del CRUD

router.get('/verCliente', crudController.getClientes);
router.post('/addCliente', crudController.addCliente);
router.put('/updateCliente/:id', crudController.updateCliente);
router.delete('/deleteCliente/:id', crudController.deleteCliente);

module.exports = router;