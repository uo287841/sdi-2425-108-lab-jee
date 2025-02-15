<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.uniovi.sdi.*,java.util.List" %>

<html lang="en">
<head>
    <title>Servlets</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
    <%@ page language="java" import="com.uniovi.sdi.* , java.util.List" %>
</head>
<body>
<jsp:useBean id="counter" class="com.uniovi.sdi.Counter"/>
<jsp:setProperty name="counter" property="increase" value="1"/>

<%-- Cambiado por el Bean
<%
 Integer counter = (Integer) application.getAttribute("counter");
 if (counter == null) {
 counter = 0;
 }
 application.setAttribute("counter", counter + 1);
%>
--%>

<!-- Barra de Navegación superior -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="collapse navbar-collapse" id="my-navbarColor02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="AddToShoppingCart">Carrito<span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="../login.jsp">Login<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="../admin.jsp">Administrar productos<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <div class="nav navbar-right">
            <!-- cambiado por el bean -->
            <%-- <%=counter%>Visitas --%>
            <jsp:getProperty name="counter" property="total"/>
            Visitas
        </div>
    </div>
</nav>
<!-- Contenido -->
div class="container" id="main-container">
<h2>Productos</h2>
<div class="row ">

    <jsp:useBean id="productsService" class="com.uniovi.sdi.ProductsService"/>
    <c:forEach var="product" begin="0" items="${productsService.products}">
        <
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
            <div>
                <img src="<c:out value="${product.image}"/>" alt=""/>
                <div><c:out value="${product.name}"/></div>
                <a href="AddToShoppingCart?product=<c:out value="${product.name}"/>"
                   class="btn btn-default">
                    <c:out value="${product.price}"/> €
                </a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>

