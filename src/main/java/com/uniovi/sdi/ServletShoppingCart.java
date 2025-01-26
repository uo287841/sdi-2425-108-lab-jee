package com.uniovi.sdi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "ServletShoppingCart", value = "/AddToShoppingCart")
public class ServletShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) session.getAttribute("cart");
        // No hay carrito, creamos uno y lo insertamos en sesión
        if (cart == null) {
            cart = new HashMap<String, Integer>();
            session.setAttribute("cart", cart);
        }
        String product = request.getParameter("product");
        if (product != null) {
            addToShoppingCart(cart, product);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Tienda SDI: Cesta de la compra</TITLE></HEAD>");
        out.println("<BODY>");
        out.println(shoppingCartToHtml(cart) + "<br>");
        //out.println("<a href=\"shop.html\">Volver</a></BODY></HTML>");
        out.println("<a href=\"index.jsp\">Volver</a></BODY></HTML>");

    }

    private void addToShoppingCart(HashMap<String, Integer> cart, String productKey) {
        if (cart.get(productKey) == null) {
            cart.put(productKey, 1);
        } else {
            int productCount = cart.get(productKey);
            cart.put(productKey, productCount + 1);
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