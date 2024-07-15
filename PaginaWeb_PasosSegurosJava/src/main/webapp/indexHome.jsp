<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/componentes/head.jsp"%>

<c:choose>
    <c:when test="${not empty sessionScope.usuario}">
        <%@include file="/componentes/indexHeaderUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/componentes/headerIndex.jsp" %>
    </c:otherwise>
</c:choose>

<!--Cuerpo de la Pagina-->
<main>
        <!--Busqueda de propiedades-->    
        <div class="slider-area">
            <div class="container slider-content">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
                        <h2>Donde tus sueños encuentran un hogar</h2>
                        
                        <p><strong>Juntos convertiremos tus sueños en realidad</strong></p>
                    
                        <div class="search-form wow pulse" data-wow-delay="0.8s">

                            <form action="" class=" form-inline">

                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="¿Que inmueble buscas?">
                                </div>
                                <div class="form-group">                                   
                                    <select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Selecciona tu ciudad">

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
                                <div class="form-group">                                     
                                    <select id="basic" class="selectpicker show-tick form-control">
                                        <option> -Estado del inmueble- </option>
                                        <option>En venta</option>
                                        <option>En arriendo</option>  

                                    </select>
                                </div>
                                <button class="btn search-btn" type="submit"><i class="fa fa-search"></i></button>                     

                            </form>
                        </div>
                    </div>        
                    
                </div>
            </div>       
        </div>
        <!--Propiedades nuevas en venta-->
        <div class="content-area recent-property" style="padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container">  
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        
                        <h2>Nuevo | En Venta</h2>
                        <p>Aquí podras encontrar nuevos inmuebles a la venta, no pierdas la oportunidad de comprar la propiedad de tus sueños</p>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-md-12  padding-top-40 properties-page">
    
                        <div class="col-md-12 "> 
                            <div id="list-type" class="proerty-th">
                                 
                                <%@include file="/componentes/propiedadesVenta.jsp"%>
                                
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-tree more-proerty text-center">
                                        <div class="item-tree-icon">
                                            <a href="${pageContext.request.contextPath}/pagePropiedades.jsp"><i class="fa fa-th"></i></a>
                                        </div>
                                        <div class="more-entry overflow">
                                            <h5><a href="${pageContext.request.contextPath}/pagePropiedades.jsp" >¿Aún no te decides? </a></h5>
                                            <h5 class="tree-sub-ttl">Ver más propiedades</h5>
                                            <button class="btn border-btn more-black" value="All properties">Todas la propiedades</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>                                     
            </div>                               
        </div>                          
        <!-- Propiedades nuevas en arriendo-->
        <div class="content-area recent-property" style="padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container">  
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        
                        <h2>Nuevo | En arriendo</h2>
                        <p>Aquí podras encontrar nuevos inmuebles en arriendo, podras alquilar un apartamento a tu gusto mientras compras el tuyo</p>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-md-12  padding-top-40 properties-page">
    
                        <div class="col-md-12 "> 
                            <div id="list-type" class="proerty-th">
                                 
                                <%@include file="/componentes/propiedadesAlquiler.jsp"%>
                                
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-tree more-proerty text-center">
                                        <div class="item-tree-icon">
                                            <a href="${pageContext.request.contextPath}/pagePropiedades.jsp"><i class="fa fa-th"></i></a>
                                        </div>
                                        <div class="more-entry overflow">
                                            <h5><a href="${pageContext.request.contextPath}/pagePropiedades.jsp" >¿Aún no te decides? </a></h5>
                                            <h5 class="tree-sub-ttl">Ver más propiedades</h5>
                                            <button class="btn border-btn more-black" value="All properties">Todas las propiedades</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>
            </div>
        </div>
    </main>




<%@include file="/componentes/footer.jsp" %>