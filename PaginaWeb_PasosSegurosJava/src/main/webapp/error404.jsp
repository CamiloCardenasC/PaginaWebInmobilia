<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="componentes/head.jsp" %>

<c:choose>
    <c:when test="${not empty sessionScope.usuario}">
        <%@include file="/componentes/indexHeaderUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="/componentes/headerIndex.jsp" %>
    </c:otherwise>
</c:choose>

<div class="content-area error-page" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <h2 class="error-title">404</h2>
                        <p>Lo sentimos, es posible que la página que solicitaste se haya movido o eliminado</p>
                        <a href="${pageContext.request.contextPath}/indexHome.jsp" class="btn btn-default">Inicio</a>                        
                    </div>
                </div> 
            </div>
        </div> 

<%@include file="componentes/footer.jsp" %>

