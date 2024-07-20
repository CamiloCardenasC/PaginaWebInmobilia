<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <!--Area del Header-->
    <header class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header" style="width: 300px">
                <a href="indexHome.html" class="navbar-brand"><img src="${pageContext.request.contextPath}/img/logo/Logo_Inmobiliaria.webp" alt="Logo_Inmobiliaria"></a>
            </div>

            <div class="collapse navbar-collapse">

                <div class="button navbar-right">
                    <ul class="ml-auto">
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link" href="#" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><strong>
                                        
                                        <c:choose>
                                            <c:when test="${not empty sessionScope.usuario}">
                                                ${sessionScope.usuario.nombrePersona} ${sessionScope.usuario.apellidosPersona}
                                            </c:when>
                                        </c:choose>
                                        
                                    </strong></span>
                                <img src="<%=request.getContextPath() %>/SvPerfilUsuario?fotoPerfil=true" class="img-profile rounded-circle" width="32" height="32">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/perfilUsuario.jsp">
                                    <i class="fa fa-user" aria-hidden="true" style="padding: 8px"></i>
                                    Perfil
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fa fa-cog" aria-hidden="true" style="padding: 8px"></i>
                                    Configuración
                                </a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/enviarPropiedad.jsp">
                                    <i class="fa fa-paper-plane" aria-hidden="true" style="padding: 8px"></i>
                                    Enviar propiedad
                                </a>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/SvAuthetication?logout=true">
                                    <i class="fa fa-sign-out" aria-hidden="true" style="padding: 8px"></i>
                                    Cerrar sesión
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
                <ul class="main-nav nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/indexHome.jsp"><strong>Inicio</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/pagePropiedades.jsp"><strong>Propiedades</strong></a></li>
                    <li><a href="#"><strong>Mi Propiedad</strong></a></li>
                    <li><a href="${pageContext.request.contextPath}/contacto.jsp"><strong>Contacto</strong></a></li>
                </ul>
            </div>
        </div>
    </header>

