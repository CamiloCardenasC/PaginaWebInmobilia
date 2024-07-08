<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <h1 class="page-title">Enviar Nueva Propiedad</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <div class="content-area submit-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">
                <div class="clearfix" > 
                    <div class="wizard-container"> 
                       
                        <div class="wizard-card ct-wizard-orange" id="wizardProperty">
                            <form action="" method="post">                        
                                <div class="wizard-header">
                                    <h3>
                                        <b>Envianos</b> TU PROPIEDAD <br>
                                        <small>Describe a detalle todas las caracteristicas de tu inmueble.</small>
                                    </h3>
                                </div>

                                <ul>
                                    <li><a href="#step1" data-toggle="tab">Paso 1 </a></li>
                                    <li><a href="#step2" data-toggle="tab">Paso 2 </a></li>
                                    <li><a href="#step3" data-toggle="tab">Paso 3 </a></li>
                                    <li><a href="#step4" data-toggle="tab">Finalizar </a></li>
                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane" id="step1">
                                        <div class="row p-b-15  ">
                                            <h4 class="info-text"> Empecemos por la información básica (validación)</h4>
                                            <div class="col-sm-4 col-sm-offset-1">
                                                <div class="picture-container">
                                                    <div class="picture">
                                                        <img src="${pageContext.request.contextPath}/img/asesoresFoto/default-property.jpg" class="picture-src" id="wizardPicturePreview" title=""/>
                                                        <input type="file" id="wizard-picture">
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label>Nombre de la propiedad <small>(Requerido)</small></label>
                                                    <input name="propertyname" type="text" class="form-control" placeholder="Super villa ...">
                                                </div>

                                                <div class="form-group">
                                                    <label>Precio de la propiedad <small>(Requerido)</small></label>
                                                    <input name="propertyprice" type="text" class="form-control" placeholder="3330000">
                                                </div> 
                                                <div class="form-group">
                                                    <label>Teléfono <small>(Requerido)</small></label>
                                                    <input name="phone" type="text" class="form-control" placeholder="+57 320 123 4567">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--  Fin del Paso 1 -->

                                    <div class="tab-pane" id="step2">
                                        <h4 class="info-text"> ¿Qué tan hermosa es su propiedad? </h4>
                                        <div class="row">
                                            <div class="col-sm-12"> 
                                                <div class="col-sm-12"> 
                                                    <div class="form-group">
                                                        <label>Descripción de la propiedad:</label>
                                                        <textarea name="discrition" class="form-control" ></textarea>
                                                    </div> 
                                                </div> 
                                            </div>

                                            <div class="col-sm-12">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Departamento :</label>
                                                        <select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Seleccione el departamento">
                                                            <option>Amazonas</option>
                                                            <option>Antioquia</option>
                                                            <option>Arauca</option>
                                                            <option>Atlántico</option>
                                                            <option>Bolívar</option>
                                                            <option>Boyacá</option>
                                                            <option>Caldas</option>
                                                            <option>Caquetá</option>
                                                            <option>Casanare</option>
                                                            <option>Cauca</option>
                                                            <option>Cesar</option>
                                                            <option>Chocó</option>
                                                            <option>Córdoba</option>
                                                            <option>Cundinamarca</option>
                                                            <option>Bogotá D.C.</option>
                                                            <option>Guainía</option>
                                                            <option>Guaviare</option>
                                                            <option>Huila</option>
                                                            <option>La Guajira</option>
                                                            <option>Magdalena</option>
                                                            <option>Meta</option>
                                                            <option>Nariño</option>
                                                            <option>Norte de Santander</option>
                                                            <option>Putumayo</option>
                                                            <option>Quindío</option>
                                                            <option>Risaralda</option>
                                                            <option>San Andrés y providencia</option>
                                                            <option>Santander</option>
                                                            <option>Sucre</option>
                                                            <option>Tolima</option>
                                                            <option>Valle</option>
                                                            <option>Vaupés</option>
                                                            <option>Vichada</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Ciudad de la propiedad :</label>
                                                        <select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Seleccione la ciudad">
                                                            <option>Armenia</option>
                                                            <option>Barrancabermeja</option>
                                                            <option>Barranquilla</option>
                                                            <option>Bello</option>
                                                            <option>Bogotá, D.C.</option>
                                                            <option>Bucaramanga</option>
                                                            <option>Buenaventura</option>
                                                            <option>Cali</option>
                                                            <option>Cartagena</option>
                                                            <option>Cúcuta</option>
                                                            <option>Dosquebradas</option>
                                                            <option>Envigado</option>
                                                            <option>Floridablanca</option>
                                                            <option>Ibagué</option>
                                                            <option>Itagüí</option>
                                                            <option>Manizales</option>
                                                            <option>Medellin</option>
                                                            <option>Montería</option>
                                                            <option>Neiva</option>
                                                            <option>Palmira</option>
                                                            <option>Pasto</option>
                                                            <option>Pereira</option>
                                                            <option>Popayán</option>
                                                            <option>Riohacha</option>
                                                            <option>Santa Marta</option>
                                                            <option>Sincelejo</option>
                                                            <option>Soacha</option>
                                                            <option>Soledad</option>
                                                            <option>Tuluá</option>
                                                            <option>Tumaco</option>
                                                            <option>Valledupar</option>
                                                            <option>Villavicencio</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Tipo de inmueble  :</label>
                                                        <select id="basic" class="selectpicker show-tick form-control">
                                                            <option>Seleccione una opción</option>
                                                            <option>Bodega o Almacén </option>
                                                            <option>Casa Adosada</option>
                                                            <option>Casa de Campo</option>
                                                            <option>Casa Unifamiliar</option>
                                                            <option>Condominio</option>
                                                            <option>Departamento o Apartamento</option>
                                                            <option>Dúplex</option>
                                                            <option>Estudio</option>
                                                            <option>Garaje o Estacionamiento</option>
                                                            <option>Local Comercial</option>
                                                            <option>Loft</option>
                                                            <option>Oficina</option>
                                                            <option>Terreno o Lote</option>

                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>La propiedad es para :</label>
                                                        <select id="basic" class="selectpicker show-tick form-control">
                                                            <option>Seleccione una opción</option>
                                                            <option>Vender </option>
                                                            <option>Arrendar</option>  

                                                        </select>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div class="col-sm-12 padding-top-15">                                                   
                                                <div class="col-sm-4">
                                                    <div class="form-group">
                                                        <label for="property-geo">Habitaciones :</label>
                                                        <select id="basic" class="selectpicker show-tick form-control">
                                                            <option>Selecciona una opción</option>
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                            <option>6</option>
                                                            <option>7</option>
                                                            <option>8</option>
                                                            <option>9 o más</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">

                                                    <div class="form-group">
                                                        <label for="price-range">Baños :</label>
                                                        <select id="basic" class="selectpicker show-tick form-control">
                                                            <option>Selecciona una opción</option>
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5 o más</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">

                                                    <div class="form-group">
                                                        <label for="property-geo">Area de la propiedad (m2) :</label>
                                                        <input name="propiedadArea" type="number" class="form-control" placeholder="52">
                                                    </div>
                                                </div>   
                                            </div>
                                            <div class="col-sm-12 padding-top-15">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Piscina
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Garaje
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>                                                 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Salida de emergencia
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>                                                 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Chimenea 
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div> 
                                            <div class="col-sm-12 padding-bottom-15">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Lavadero / Habitacion de lavado
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Patio
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Balcón
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> Azotea
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                        </div>
                                    </div>
                                    <!-- End step 2 -->

                                    <div class="tab-pane" id="step3">                                        
                                        <h4 class="info-text">Envianos unas imagenes y/o videos del inmueble. </h4>
                                        <div class="row">  
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="property-images">Selecciona una imagen  :</label>
                                                    <input class="form-control" type="file" id="property-images">
                                                    <p class="help-block">Seleccione multiples imagendes de su propiedad.</p>
                                                </div>
                                            </div>
                                            <div class="col-sm-6"> 
                                                <div class="form-group">
                                                    <label for="property-video">Videos de la propiedad :</label>
                                                    <input class="form-control" value="" placeholder="http://www.youtube.com, http://vimeo.com" name="property_video" type="text">
                                                </div> 

                                                <div class="form-group">
                                                    <input class="form-control" value="" placeholder="http://www.youtube.com, http://vimeo.com" name="property_video" type="text">
                                                </div>

                                                <div class="form-group">
                                                    <input class="form-control" value="" placeholder="http://www.youtube.com, http://vimeo.com" name="property_video" type="text">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--  End step 3 -->


                                    <div class="tab-pane" id="step4">                                        
                                        <h4 class="info-text"> Finalizar y Enviar </h4>
                                        <div class="row">  
                                            <div class="col-sm-12">
                                                <div class="">
                                                    <p>
                                                        <label><strong>Terminos y condiciones.</strong></label>
                                                        Al acceder o utilizar los servicios de Pasos Seguros, tales como 
                                                        publicar el anuncio de su propiedad con su información personal 
                                                        información en nuestro sitio web usted acepta las
                                                        recopilación, uso y divulgación de su información personal 
                                                        en la forma legal adecuada.
                                                    </p>

                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" /> <strong>Acepto terminos y condiciones.</strong>
                                                        </label>
                                                    </div> 

                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                    <!--  End step 4 -->

                                </div>

                                <div class="wizard-footer">
                                    <div class="pull-right">
                                        <input type='button' class='btn btn-next btn-primary' name='next' value='Siguiente' />
                                        <input type='button' class='btn btn-finish btn-primary ' name='finish' value='Finalizar' />
                                    </div>

                                    <div class="pull-left">
                                        <input type='button' class='btn btn-previous btn-default' name='previous' value='Anterior' />
                                    </div>
                                    <div class="clearfix"></div>                                            
                                </div>	
                            </form>
                        </div>
                        <!-- End submit form -->
                    </div> 
                </div>
            </div>
        </div>

<%@include file="/componentes/footer.jsp" %>
