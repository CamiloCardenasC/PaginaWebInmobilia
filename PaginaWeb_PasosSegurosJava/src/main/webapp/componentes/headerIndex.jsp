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
                    <button class="navbar-btn nav-button login" onclick="window.location.href='inicioSesion.jsp'">Iniciar sesión</button>
                    <button class="navbar-btn nav-button enviar" onclick="window.location.href='registroCliente.jsp'">Registrarse</button>
                </div>

                <ul class="main-nav nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/indexHome.jsp"><strong>Inicio</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/pagePropiedades.jsp"><strong>Propiedades</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/inicioSesion.jsp"><strong>Mi Propiedad</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/contacto.jsp"><strong>Contacto</strong></a></li>
                </ul>
            </div>
        </div>
    </header>
