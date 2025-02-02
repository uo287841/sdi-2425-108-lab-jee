package com.uniovi.sdi;

// Responde con post

/*
@WebServlet(name = "DeleteFromShoppingCart", value = "/DeleteFromShoppingCart")
public class DeleteFromShoppingCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<String, Integer>();
            session.setAttribute("cart", cart);
        }

        String product = request.getParameter("product");
        String method = request.getParameter("method");
        if (product != null && "DELETE".equalsIgnoreCase(method)) {
            removeFromShoppingCartByItem(cart, product);
        }

    }

    private void removeFromShoppingCartByItem(HashMap<String, Integer> cart, String productKey) {

        if (cart.get(productKey) != null) {
            int productCount = cart.get(productKey);
            if(productCount <= 0) {
                cart.remove(productKey);
            }
            else {
                cart.put(productKey, productCount - 1);
            }
        }
    }

    private String shoppingCartToHtml(HashMap<String, Integer> cart) {
        StringBuilder shoppingCartToHtml = new StringBuilder();

        for (String key : cart.keySet()) {
            shoppingCartToHtml.append("<p>[").append(key).append("],").append(cart.get(key)).append("< unidades/p>");
        }
        return shoppingCartToHtml.toString();
    }
}

/*
Añadir en cart.jsp
Crear un boton de tipo submmit, Cuando haga click en el boton, genera un submit
llamame al server por el metodo post, desde el server a end point por el post

en un campo hidden, nombre: _method, valor: DELETE
Si no usas hidden se muestra formulario completo


<div class = "container" id="main-container">
    <h2> Vista Carrito</h2>
    <ul>
        <c:forEach var:"item" items='${selectedItem}' >
        <li> ${item.key} - ${item.value}
        <span>
            <form action="DeleteFromShopingCart" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="product" value ='${item.key}'>
                <button type="submit" class="btn btn danger"> Eliminar</button>
            </form>
        </span>
        </li>
        </c:forEach>
        </ul>
        <a href="index,jsp"> Volver </a>



*/
