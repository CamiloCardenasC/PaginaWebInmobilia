
document.getElementById('registroFormulario').addEventListener('submit', function(event) {

//Esto previene que el formulario se envie de forma tradicional
event.defaultPrevented();

//Se verifica que las contraseñas coincidan
if(!validarPassword()){
    return;
}

//Recogemos todos los valores del formulario
const nombreUsuario = document.getElementById('nombreUsuario').value;
const apellidosUsuario = document.getElementById('apellidosUsuario').value;
const fechaNacimiento = document.getElementById('fechaNacimiento').value;
const telefono = document.getElementById('telefono').value;
const emailUsuario = document.getElementById('emailUsuario').value;
const passwordUsuario = document.getElementById('passwordUsuario').value;

//Se crea un objeto para enviar a la base de datos
const data = {nombreUsuario, apellidosUsuario, fechaNacimiento, telefono, emailUsuario, passwordUsuario};

//Se envia los datos a la API usando Fetch
fetch('http://localhost:10000/api/addCliente', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    dody: JSON.stringify(data)
}).then(response => response.json()).then(data => {
    if(data.error){
        document.getElementById('error-mensaje').textContent = data.error;
    } else {
        alert('Registro Exitoso');

        window.location.href = 'inicioSesion.html'
    }
}).catch(error => {
    console.error('error', error);
    document.getElementById('error-mensaje').textContent = 'Hubo un problema con el registro. Por favor, intente nuevamente.';
});

});