<%-- 
    Document   : RegistroCliente
    Created on : 19 may 2024, 1:03:56 p.m.
    Author     : kmilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
    </head>
    <body>
        <h1>Registrarse</h1>
                
                <form action="SvRegistroCliente" method="POST">
                    <div class="usuarioRegistro">
                        <label for="nombreUsuario">* Nombre</label>
                        <input type="text" id="nombreUsuario" name="nombreUsuario" placeholder="Escriba su nombre" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="apellidos">* Apellidos</label>
                        <input type="text" id="apellidos" name="apellidosUsuario" placeholder="Escriba sus Apellidos" required>
                    
                    </div>
                    <div class="usuarioRegistro">
                        <label for="fechaNacimiento">* Fecha de nacimiento</label>
                        <input type="date" id="fechaNaci" name="fechaNacimiento" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="telefono">* Telefono/Movil</label>
                        <input type="tel" id="telefono" name="telefonoUsuario" placeholder="xxx-xxx-xxxx" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="email">* Correo electrónico</label>
                        <input type="email" id="email" name="emailUsuario" placeholder="example@dominio.com" required>
                        
                    </div>
                    <div class="usuarioRegistro">
                        <label for="password">* Contraseña</label>
                        <input type="password" id="password" name="passwordUsuario" required>

                    </div>
                    <div class="usuarioRegistro">
                        <label for="confirmarPassword">* Confirmar Contraseña</label>
                        <input type="password" id="confirmarPassword" name="confirmarPassword" required>
                    </div>
                    <div class="textContraseña">
                        <p>7 caracteres como mínimo con al menos una letra y un número, 
                            sensible a mayúsculas y minúsculas. Caracteres especiales 
                            permitidos: @ # $% ^ & + =!</p>
                    </div>


                    <div class="buttonRegistrarse">
                        <button type="submit" class="resgistrarse"><strong>Registrarse</strong></button>
                    </div>
                </form>
        
    </body>
</html>
