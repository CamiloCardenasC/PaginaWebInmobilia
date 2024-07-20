<%@page import="logica.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/componentes/head.jsp" %>

    <%
        Cliente usuario = (Cliente) session.getAttribute("usuario");
        
    %>

<c:choose>
    <c:when test="${not empty sessionScope.usuario}">
        <%@include file="/componentes/indexHeaderUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/componentes/headerIndex.jsp" %>
    </c:otherwise>
</c:choose>



        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">Bienvenido : 
                            <span class="blue strong">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.usuario}">
                                        ${sessionScope.usuario.nombrePersona} ${sessionScope.usuario.apellidosPersona}
                                    </c:when>
                                </c:choose>
                            </span>
                        </h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header --> 

        <!-- property area -->
        <div class="content-area user-profiel" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">   
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 profiel-container" style="color: #005A7A;">

                        <form action="SvPerfilUsuario" method="POST" enctype="multipart/form-data">
                            <div class="profiel-header">
                                <h3 style="color: #00A2DE;">
                                    <b style="color: #005A7A;">MEJORA</b> TU PERFIL <br>
                                    <small>Esta información nos permitirá saber más sobre usted.</small>
                                </h3>
                                <hr>
                            </div>

                            <div class="clear">
                                <div class="col-sm-4 col-sm-offset-1">
                                    <div class="picture-container">
                                        <div class="picture">
                                            
                                            <img src="SvPerfilUsuario" class="picture-src" id="wizardPicturePreview" title="" alt="Foto de perfil"/>     
                                            <input type="file" id="wizard-picture" name="fotoPerfil">
                                        </div>
                                        <h6>Elegir una foto</h6>
                                    </div>
                                </div>

                                <div class="col-sm-3 padding-top-25">

                                    <div class="form-group">
                                        <label for="nombreCliente">Nombre/s </label>
                                        <input name="nombreCliente" type="text" class="form-control" value="${usuario != null ? usuario.getNombrePersona() : ''}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellidosCliente">Apellidos </label>
                                        <input name="apellidosCliente" type="text" class="form-control" value="${usuario != null ? usuario.getApellidosPersona() : ''}">
                                    </div> 
                                    <div class="form-group">
                                        <label for="emailCliente">Correo electronico </label>
                                        <input name="emailCliente" type="email" class="form-control" readonly value="${usuario != null ? usuario.getCorreoElectronico() : ''}">
                                    </div> 
                                </div>
                                <div class="col-sm-3 padding-top-25">
                                    <div class="form-group">
                                        <label for="fechaNacimientoCliente">Fecha de nacimiento </label>
                                        
                                        <input name="fechaNacimientoCliente" type="text" class="form-control" readonly
                                               value="<fmt:formatDate value='${usuario.getFechaNacimiento()}' pattern='dd-MM-yyyy'/>">
                                               
                                       
                                        
                                    </div>
                                    <div class="form-group">
                                        <label for="telefonoCliente">Telefono </label>
                                        <input name="telefonoCliente" type="tel" class="form-control" value="${usuario != null ? usuario.getTelefonoPersona() : ''}">
                                    </div>
                                    <div class="col-sm-5 col-sm-offset-1">
                                        <br>
                                        <input type='button' class='btn btn-finish btn-primary' name='Cambiar contraseña' value='Cambiar contraseña' />
                                    </div>
                                </div>  

                            </div>

                            <div class="clear">
                                <br>
                                <hr>
                                <br>
                                <div class="col-sm-5 col-sm-offset-1">
                                    <div class="form-group">
                                        <label for="facebook">Facebook :</label>
                                        <input name="facebook" type="text" class="form-control" placeholder="https://facebook.com/user" value="${usuario != null ? usuario.getFacebook() : ''}">
                                    </div>
                                    <div class="form-group">
                                        <label for="twitter">Twitter :</label>
                                        <input name="twitter" type="text" class="form-control" placeholder="https://Twitter.com/@user" value="${usuario != null ? usuario.getTwitter() : ''}">
                                    </div>
                                </div>  

                                <div class="col-sm-5">
                                    <div class="form-group">
                                        <label for="p-email">Correo electronico Publico :</label>
                                        <input name="p-email" type="email" class="form-control" placeholder="p-email@gmail.com" value="${usuario != null ? usuario.getCorreoPublico() : ''}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefonoPub">Telefono Público :</label>
                                        <input name="telefonoPub" type="tel" class="form-control" placeholder="+57 300 900 9000" value="${usuario != null ? usuario.getTelefonoPublico() : ''}">
                                    </div>
                                </div>
 
                            </div>
                    
                            <div class="col-sm-5 col-sm-offset-1">
                                <br>
                                <button type="submit" class='btn btn-finish btn-primary' name="guardar">Guardar cambios</button>
                               
                            </div>
                            <br>
                    </form>

                </div>
            </div><!-- end row -->

        </div>
    </div>


<%@include file="/componentes/footer.jsp" %>