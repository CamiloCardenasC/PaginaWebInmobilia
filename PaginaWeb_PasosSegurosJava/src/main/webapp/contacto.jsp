<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="componentes/head.jsp"%>
    
<c:choose>
    <c:when test="${not empty sessionScope.usuario}">
        <%@include file="/componentes/indexHeaderUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/componentes/headerIndex.jsp" %>
    </c:otherwise>
</c:choose>

    <!-- Imagen Contacto -->
    <div class="page-head"> 
        <div class="container">
            <div class="row">
                <div class="page-head-content">
                    <h1 class="page-title">Contáctenos</h1>               
                </div>
            </div>
        </div>
    </div>
    

        <!-- Area formulario de contacto -->
        <div class="content-area recent-property padding-top-40" style="background-color: #FFF;">
            <div class="container">  
                <div class="row">
                    <div class="col-md-8 col-md-offset-2"> 
                        <div class="" id="contact1">                        
                            <div class="row">
                                <div class="col-sm-4">
                                    <h3 style="color: #005a7a"><i class="fa fa-map-marker"></i> Dirección</h3>
                                    <p>Cra. 93A #11A-41
                                        <br>Bogotá D.C.
                                        <br>
                                        <strong style="color: #005a7a">Colombia</strong>
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3 style="color: #005a7a"><i class="fa fa-phone"></i> Teléfonos</h3>
                                    <p class="text-muted">Este número es gratuito si llama desde
                                        Colombia, de lo contrario le recomendamos que utilice el formato electrónico.
                                        Forma de comunicación.</p>
                                    <p style="color: #005a7a"><strong>+57 322 379 8988</strong></p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3 style="color: #005a7a"><i class="fa fa-envelope"></i> Correo electrónico</h3>
                                    <p class="text-muted">No dude en escribirnos un correo electrónico o llamar a nuestras lineas nacionales.</p>
                                    <ul>
                                        <li><strong><a href="mailto:">solicitudes@PasosSeguros.com</a></strong>   </li>
                                    </ul>
                                </div>
                                <!-- /.col-sm-4 -->
                            </div>
                            <!-- /.row -->
                            <hr>
                            <h2 style="color: #005a7a">Formulario de Contacto</h2>
                            <form>
                                <div class="row" style="color: #005a7a">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="firstname">Nombre(s)*</label>
                                            <input type="text" class="form-control" id="firstname" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="lastname">Apellidos *</label>
                                            <input type="text" class="form-control" id="lastname" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Correo electrónico *</label>
                                            <input type="text" class="form-control" id="email" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="subject">Asunto *</label>
                                            <input type="text" class="form-control" id="subject" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label for="message">Mensaje *</label>
                                            <textarea id="message" class="form-control" required></textarea>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 text-center">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Enviar Mensaje</button>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </form>
                        </div>
                    </div>    
                </div>
            </div>
        </div>



<%@include file="componentes/footer.jsp"%>

