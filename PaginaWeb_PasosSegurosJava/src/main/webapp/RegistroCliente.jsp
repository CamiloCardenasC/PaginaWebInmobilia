<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse</title>
    <link rel="stylesheet" href="css/style_RegistroUsuario.css">
    <link rel="icon" href="img/logo/logoPestaña.ico">
    <script>
        //Se crea una funcion para validar la contraseña
        function validarPassword() {
            const password = document.getElementById('password').value; // Guardamos la contraseña
            const confirmarPassword = document.getElementById('confirmarPassword').value; // Se guarda la contraseña a verificar
            const errorMensaje = document.getElementById('error-message'); // Mensaje de error
            
            if (password !== confirmarPassword) {
                errorMensaje.textContent = "Las contraseñas no coinciden";
                return false; // Se retorna Falso para que el formulario no se envíe si no coinciden.
            } else {
                errorMensaje.textContent = "";
                return true; // Si coinciden se envía el formulario y se guarda en la BD
            }
        }
    </script>
</head>
<body>
    <Div class="Container-Registrarse">
        <div class="container-izquierdo">
                <h1>Registrarse</h1>
                
                <div class="arrow-back-container">
                    <a href="indexHome.jsp" class="arrow-back">&#8592;</a>
                </div>

                <%--El formulario tiene el atributo onsubmit para llamar la funcion validarPassword cuando
                 se trate de enviar el formulario--%>
                <form action="SvRegistroCliente" method="POST" onsubmit="return validarPassword()">
                    <div class="usuarioRegistro">
                        <label for="nombreUsuario">* Nombre</label>
                        <input type="text" id="nombreUsuario" name="nombreUsuario" placeholder="Escriba su nombre" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="apellidos">* Apellidos</label>
                        <input type="text" id="apellidos" name="apellidosUsuario" placeholder="Escriba sus Apellidos" required>
                    
                    </div>
                    <div class="usuarioRegistro">
                        <label for="fechaNaci">* Fecha de nacimiento</label>
                        <input type="date" id="fechaNaci" name="fechaNacimiento" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="telefono">* Telefono/Movil</label>
                        <input type="tel" id="telefono" name="telefonoUsuario" placeholder="xxx-xxx-xxxx" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="email">* Correo electrónico</label>
                        <input type="email" id="email" name="emailUsuario" placeholder="example@dominio.com" autocomplete="off" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="password">* Contraseña</label>
                        <input type="password" id="password" name="passwordUsuario" required>

                    </div>
                    <div class="usuarioRegistro">
                        <label for="password">* Confirmar Contraseña</label>
                        <input type="password" id="confirmarPassword" name="password" required>
                    </div>
                    
                    <div id="error-message" style="color: red;"></div>
                    
                    <div class="textContraseña">
                        <p>7 caracteres como mínimo con al menos una letra y un número, 
                            sensible a mayúsculas y minúsculas. Caracteres especiales 
                            permitidos: @ # $% ^ & + =!</p>
                    </div>

                    
                    
                    <div class="buttonRegistrarse">
                        <button type="submit" class="resgistrarse"><strong>Registrarse</strong></button>
                    </div>
                </form>
        <div class="iniciar">
                    <p>¿Ya tienes una cuenta?</p>
                    <p><a href="inicioSesion.jsp">Iniciar Sesión</a></p>
                </div>
        </div>
        <div class="container-Derecho">
        </div>
    </Div>
    
</body>
</html>