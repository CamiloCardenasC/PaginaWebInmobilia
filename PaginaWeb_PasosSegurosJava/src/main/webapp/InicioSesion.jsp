<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Sesion</title>
    <link rel="stylesheet" href="css/style_InicioSesion.css">    
    <link rel="icon" href="img/logo/logoPestaña.ico">
</head>
<body>
    <Div class="Container-InicioSesion">
        <div class="container-izquierdo">
                
            <h1>Iniciar Sesion</h1>
                <div class="arrow-back-container">
                    <a href="indexHome.jsp" class="arrow-back">&#8592;</a>
                </div>
                <div>
                <% String errorMensaje = (String) request.getAttribute("error");
                    if(errorMensaje != null){
                        out.println("<p style='color: red;'>" + errorMensaje + "</p>");
                    }
                %>
                </div>
                <form action="SvAuthetication" method="POST">
                    
                    
                    
                    <div class="usuarioInicio">
                        <input type="email" id="correoElectronico" name="correoElectronico" required>
                        <label for="correoElectronico">Correo electrónico</label>
                        <span></span>
                    </div>
                    <div class="usuarioInicio">
                        <input type="password" id="password" name="password" required>
                        <label for="password">Contraseña</label>
                        <span></span>
                    </div>
                    <div class="buttonIniciarSesion">
                        <button type="submit" class="iniciar"><strong>INICIAR</strong></button>
                    </div>
                </form> 
                <div class="olvidoContraseña">
                    <p><a href="#">¿Olvido su contraseña?</a></p>
                </div>
                <div class="unete">
                    <p>¿Aún no tienes una cuenta?</p>
                    <p><a href="registroCliente.jsp">Únete</a></p>
                </div>
        </div>
        <div class="container-Derecho">
        </div>
    </Div>
</body>
<script>
   // Selecciona todos los inputs dentro de elementos con la clase "campo"
    const inputs = document.querySelectorAll('.usuarioInicio input');

    // Itera sobre cada input
    inputs.forEach(input => {
    // Selecciona el label asociado al input actual
    const label = input.nextElementSibling;

    // Agrega un evento de escucha para el evento focus del input
    input.addEventListener('focus', function() {
        // Mueve el label a la posición superior
        label.style.top = '-6px';
    });

    // Agrega un evento de escucha para el evento blur del input
    input.addEventListener('blur', function() {
        // Verifica si el input está vacío
        if (input.value === '') {
            // Si está vacío, devuelve el label a su posición original
            label.style.top = '50%';
        }
    });
});
</script>
</html>