<%--
  Created by IntelliJ IDEA.
  User: UO287841
  Date: 29/01/2025
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product View</title>
</head>
<body>
    <h2>Lista de productos</h2>
    <thead>
    <tr>
        <th>
            Image
        </th>
        <th>
            Nombre
        </th>
        <th>
            Precio
        </th>
        <th>
            Accion
        </th>
    </tr>
    </thead>

    <tbody>
        <c:forEach var="product" items='$(storeProducts)'>
            <tr>
                <td>
                    <img src=<c:out value='$(product.image)' />  alt='<c:out value='product.name' />'
                        style = 'width: 100 px;' />
                </td>
            <td>

            </td>
            </tr>
    </tbody>

</body>
</html>
