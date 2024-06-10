<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/componentes/head.jsp"%>
<%@include file="/componentes/headerIndex.jsp"%>

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
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/CasaVenta1.webp" alt="inmuebleVenta1"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Villa Rosales </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 220m </span>
                                            <span class="proerty-price pull-right"> $ 210'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(5)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/CasaVenta2.jpg" alt="inmuebleVenta2"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Alquinos II </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 110m </span>
                                            <span class="proerty-price pull-right"> $ 140'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/CasaVenta3.webp" alt="inmuebleVenta3"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Tunjuelito </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 70m </span>
                                            <span class="proerty-price pull-right"> $ 200'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(4)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/CasaVenta4.webp" alt="inmuebleVenta4"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Ensueño </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 160m </span>
                                            <span class="proerty-price pull-right"> $ 430'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(12)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(5)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/CasaVenta5.jpg" alt="inmuebleVenta5"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Socorro </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 60m </span>
                                            <span class="proerty-price pull-right"> $ 170'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(4)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1) 
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/aptoVenta1.webp" alt="inmuebleVenta6"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Rosales I </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 70m </span>
                                            <span class="proerty-price pull-right"> $ 150'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1) 
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/aptoVenta2.jpg" alt="inmuebleVenta7"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Parque Campestre IX </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 100m </span>
                                            <span class="proerty-price pull-right"> $ 320'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(4)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-tree more-proerty text-center">
                                        <div class="item-tree-icon">
                                            <i class="fa fa-th"></i>
                                        </div>
                                        <div class="more-entry overflow">
                                            <h5><a href="property-1.html" >¿Aún no te decides? </a></h5>
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
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/AlquilerApto1.jpg" alt="inmuebleAlquiler1"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> San Juan Norte I </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 70m </span>
                                            <span class="proerty-price pull-right"> $ 2'500.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/AlquilerApto2.jpg" alt="inmuebleAlquiler2"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Ciudad Latina </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 55m </span>
                                            <span class="proerty-price pull-right"> $ 1'100.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/AlquilerApto3.jpg" alt="inmuebleAlquiler3"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Tintal II </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 65m </span>
                                            <span class="proerty-price pull-right"> $ 1'000.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/AlquilerCasa4.jpg" alt="inmuebleAlquiler4"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Villa Sur </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 120m </span>
                                            <span class="proerty-price pull-right"> $ 3'300.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(5)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/AlquilerCasa5.jpg" alt="inmuebleAlquiler5"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> La Estancia </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 100m </span>
                                            <span class="proerty-price pull-right"> $ 1'900.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(4)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/casaArriendo1.jpg" alt="inmuebleAlquiler6"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Kennedy I </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 60m </span>
                                            <span class="proerty-price pull-right"> $ 1'000.000 Mes</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(2)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(1)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="${pageContext.request.contextPath}/img/opcionesCasas/casaArriendo2.jpg" alt="inmuebleAlquiler7"></a>
                                        </div>
    
                                        <div class="item-entry overflow">
                                            <h5><a href="property-1.html"> Jackeline II </a></h5>
                                            <div class="dot-hr"></div>
                                            <span class="pull-left"><b> Area :</b> 50m </span>
                                            <span class="proerty-price pull-right"> $ 1'000.000</span>
                                            <p style="display: none;">Suspendisse ultricies Suspendisse ultricies Nulla quis dapibus nisl. Suspendisse ultricies commodo arcu nec pretium ...</p>
                                            <div class="property-icon">
                                                <img src="${pageContext.request.contextPath}/img/icon/bed.png" alt="habitacion">(3)|
                                                <img src="${pageContext.request.contextPath}/img/icon/shawer.png" alt="baño">(1)|
                                                <img src="${pageContext.request.contextPath}/img/icon/cars.png" alt="parqueadero">(0)  
                                            </div>
                                        </div>
    
    
                                    </div>
                                </div> 
    
                                <div class="col-sm-6 col-md-3 p0">
                                    <div class="box-tree more-proerty text-center">
                                        <div class="item-tree-icon">
                                            <i class="fa fa-th"></i>
                                        </div>
                                        <div class="more-entry overflow">
                                            <h5><a href="property-1.html" >¿Aún no te decides? </a></h5>
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