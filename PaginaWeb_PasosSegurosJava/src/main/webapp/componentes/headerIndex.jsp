<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <!--Area del Header-->
    <header class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header" style="width: 300px">
                <a href="indexHome.html" class="navbar-brand"><img src="${pageContext.request.contextPath}/img/logo/Logo_Inmobiliaria.webp" alt="Logo_Inmobiliaria"></a>
            </div>

            <div class="collapse navbar-collapse">
                
                <div class="button navbar-right">
                    <button class="navbar-btn nav-button login" onclick="window.open('inicioSesion.jsp')">Iniciar sesión</button>
                    <button class="navbar-btn nav-button enviar" onclick=" window.open('registroCliente.jsp')">Registrarse</button>
                </div>

                <ul class="main-nav nav navbar-nav navbar-right">
                    <li><a href="#"><strong>Inicio</strong></a></li>
                    <li><a href=""><strong>Propiedades</strong></a></li>
                    <li><a href=""><strong>Mi Propiedad</strong></a></li>
                    <li><a href=""><strong>Contacto</strong></a></li>
                </ul>
            </div>
        </div>
    </header>
