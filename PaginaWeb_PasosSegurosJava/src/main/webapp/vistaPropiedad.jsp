<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/componentes/head.jsp" %>

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
                        <h1 class="page-title">Caracteristicas</h1>               
                    </div>
                </div>
            </div>
        </div>
        

        <!-- Area de la propiedad-->
        <div class="content-area single-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">   

                <div class="clearfix padding-top-40" >

                    <div class="col-md-8 single-property-content prp-style-2">
                        <div class="">
                            <div class="row">
                                <div class="light-slide-item">            
                                    <div class="clearfix">
                                        <div class="favorite-and-print">
                                            <a class="add-to-fav" href="#login-modal" data-toggle="modal">
                                                <i class="fa fa-star-o"></i>
                                            </a>
                                            <a class="printer-icon " href="javascript:window.print()">
                                                <i class="fa fa-print"></i> 
                                            </a>
                                        </div> 

                                        <ul id="image-gallery" class="gallery list-unstyled cS-hidden">
                                            <li data-thumb="${pageContext.request.contextPath}/img/interiorCasa/salaCasa.jpg"> 
                                                <img src="${pageContext.request.contextPath}/img/interiorCasa/salaCasa.jpg" />
                                            </li>
                                            <li data-thumb="${pageContext.request.contextPath}/img/interiorCasa/cocina.jpg"> 
                                                <img src="${pageContext.request.contextPath}/img/interiorCasa/cocina.jpg" />
                                            </li>
                                            <li data-thumb="${pageContext.request.contextPath}/img/interiorCasa/habitacion.jpg"> 
                                                <img src="${pageContext.request.contextPath}/img/interiorCasa/habitacion.jpg" />
                                            </li>
                                            <li data-thumb="${pageContext.request.contextPath}/img/interiorCasa/habitacionSencilla.jpg"> 
                                                <img src="${pageContext.request.contextPath}/img/interiorCasa/habitacionSencilla.jpg" />
                                            </li>
                                            <li data-thumb="${pageContext.request.contextPath}/img/interiorCasa/baño.jpg"> 
                                                <img src="${pageContext.request.contextPath}/img/interiorCasa/baño.jpg" />
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="single-property-wrapper">

                                <div class="section">
                                    <h4 class="s-property-title">Descripción</h4>
                                    <div class="s-property-content">
                                        <p>
                                            Esta propiedad de 200 metros cuadrados, ubicada en la exclusiva 
                                            zona norte de Bogotá, ofrece 5 amplios dormitorios, 3 baños completos, 
                                            garaje para 2 autos, espacios luminosos, acabados de alta calidad, zonas 
                                            verdes y seguridad las 24 horas. Ideal para familias numerosas o quienes 
                                            buscan un hogar cómodo y bien ubicado. ¡No pierdas la oportunidad de 
                                            convertirla en tu nuevo hogar!
                                        </p>
                                    </div>
                                </div>
                                <!-- Fin del area de la descripción  -->

                                <div class="section additional-details">

                                    <h4 class="s-property-title">Detalles adicionales</h4>

                                    <ul class="additional-details-list clearfix">
                                        <li>
                                            <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">Localidad</span>
                                            <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">Chapinero</span>
                                        </li>
                 
                                        <li>
                                            <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">Urbanización</span>
                                            <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">Los Angeles 2/span>
                                        </li>

                                        <li>
                                            <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">Época de Construcción</span>
                                            <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">2003</span>
                                        </li>
                                        <li>
                                            <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">Parqueadero</span>
                                            <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">Espacio para dos automoviles, estacionamiento cubierto</span>
                                        </li>

                                        <li>
                                            <span class="col-xs-6 col-sm-4 col-md-4 add-d-title">Zona</span>
                                            <span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">Urbana</span>
                                        </li>

                                    </ul>
                                </div>  
                                <!-- Fin del area de detalles  -->

                                <div class="section property-share"> 
                                    <h4 class="s-property-title">Compartir con tus amigos </h4> 
                                    <div class="roperty-social">
                                        <ul> 
                                            <li><a title="Share this on facebok " href="https://www.facebook.com"><i class="fa fa-facebook-square fa-3x" aria-hidden="true"></i></a></li>                                         
                                            <li><a title="Share this on telegram " href="#"><i class="fa fa-whatsapp fa-3x" aria-hidden="true"></i></a></li> 
                                            <li><a title="Share this on instagram " href="#"><i class="fa fa-instagram fa-3x" aria-hidden="true"></i></a></li> 
                                            <li><a title="Share this on google plus " href="#"><i class="fa fa-pinterest-square fa-3x" aria-hidden="true"></i></a></li> 
                                            <li><a title="Share this on twitter " href="#"><i class="fa fa-twitter-square fa-3x" aria-hidden="true"></i></a></li> 
                                            <li><a title="Share this on youtube " href="#"><i class="fa fa-youtube-square fa-3x" aria-hidden="true"></i></a></li> 
                                            <li><a title="Share this on linkedin " href="#"><i class="fa fa-linkedin-square fa-3x" aria-hidden="true"></i></a></li>                                        
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 p0">
                        <aside class="sidebar sidebar-property blog-asside-right property-style2">
                            <div class="dealer-widget">
                                <div class="dealer-content">
                                    <div class="inner-wrapper">
                                        <div class="single-property-header">                                          
                                            <h1 class="property-title">Villa in Coral Gables</h1>
                                            <span class="property-price">$825,000</span>
                                        </div>

                                        <div class="property-meta entry-meta clearfix ">   

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info-icon icon-tag">                                                                                      
                                                    <img src="${pageContext.request.contextPath}/img/icon/sale_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Estado</span>
                                                    <span class="property-info-value">En Venta</span>
                                                </span>
                                            </div>

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info icon-area">
                                                    <img src="${pageContext.request.contextPath}/img/icon/area_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Area</span>
                                                    <span class="property-info-value">200 <b class="property-info-unit">M<sub>2</sub></b></span>
                                                </span>
                                            </div>

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info-icon icon-bed">
                                                    <img src="${pageContext.request.contextPath}/img/icon/habitacion_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Dormitorios</span>
                                                    <span class="property-info-value">3</span>
                                                </span>
                                            </div>

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info-icon icon-bath">
                                                    <img src="${pageContext.request.contextPath}/img/icon/baño_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Baños</span>
                                                    <span class="property-info-value">2</span>
                                                </span>
                                            </div>

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info-icon icon-garage">
                                                    <img src="${pageContext.request.contextPath}/img/icon/Garaje_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Garaje</span>
                                                    <span class="property-info-value">1</span>
                                                </span>
                                            </div>

                                            <div class="col-xs-4 col-sm-4 col-md-4 p-b-15">
                                                <span class="property-info-icon icon-garage">
                                                    <img src="${pageContext.request.contextPath}/img/icon/patio_blue.png">
                                                </span>
                                                <span class="property-info-entry">
                                                    <span class="property-info-label">Patio</span>
                                                    <span class="property-info-value">No tiene</span>
                                                </span>
                                            </div>


                                        </div>
                                        <div class="dealer-section-space">
                                            <span>Información del Asesor</span>
                                        </div>
                                        <div class="clear">
                                            <div class="col-xs-4 col-sm-4 dealer-face">
                                                <a href="">
                                                    <img src="${pageContext.request.contextPath}/img/asesoresFoto/Asesora Natalia Gomez.jpg" class="img-circle">
                                                </a>
                                            </div>
                                            <div class="col-xs-8 col-sm-8 ">
                                                <h3 class="dealer-name">
                                                    <a href="">Natalia Gómez</a>
                                                    <span>Asesora de bienes raíces</span>        
                                                </h3>
                                                <div class="dealer-social-media">
                                                    <a class="twitter" target="_blank" href="">
                                                        <i class="fa fa-twitter"></i>
                                                    </a>
                                                    <a class="facebook" target="_blank" href="">
                                                        <i class="fa fa-facebook"></i>
                                                    </a>
                                                    <a class="gplus" target="_blank" href="">
                                                        <i class="fa fa-google-plus"></i>
                                                    </a>
                                                    <a class="linkedin" target="_blank" href="">
                                                        <i class="fa fa-linkedin"></i>
                                                    </a> 
                                                    <a class="instagram" target="_blank" href="">
                                                        <i class="fa fa-instagram"></i>
                                                    </a>       
                                                </div>

                                            </div>
                                        </div>

                                        <div class="clear">
                                            <ul class="dealer-contacts">                                       
                                                <li><i class="pe-7s-map-marker strong"> </i> Cra. 93A #11A-41</li>
                                                <li><i class="pe-7s-mail strong"> </i> nataliagomez@PasosSeguros.com</li>
                                                <li><i class="pe-7s-call strong"> </i> +57 312 367 3674</li>
                                            </ul>
                                            <p>Experta en el sector inmobiliario. Estoy aquí para ayudarle con todas sus inquietudes y necesidades en bienes raíces. ¡Confíe en su experiencia para encontrar la mejor solución!</p>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            
                            <!-- Componente de busqueda inteligente  -->
                            <%@include file="componentes/busquedaInteligente.jsp" %>
                            
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Anuncios </h3>
                                </div>
                                <div class="panel-body recent-property-widget">
                                    <img src="assets/img/ads.jpg">
                                </div>
                            </div>
                           
                        </aside>
                    </div>

                </div>

            </div>
        </div>

        

<%@include file="/componentes/footer.jsp" %>