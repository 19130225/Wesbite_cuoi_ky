package com.example.demo11.Controller;

import com.example.demo11.Sevice.PDSevice;
import com.example.demo11.dao.ProductDao;
import com.example.demo11.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchAjaxProduct", value = "/SearchAjaxProduct")
public class SearchAjaxProduct extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        ProductDao productDao=new ProductDao();

        List<Product> list = productDao.searchProduct(txtSearch);
        PrintWriter out = response.getWriter();
        for (Product o : list) {
            out.println("<div class=\"col-sm-3 col-md-6 col-lg-4\">\n" +
                    "                        <div class=\"card\">\n" +
                    "                            <div class=\"card-body text-center\">\n" +
                    "                                <a href=\"PDDetailsServlet?id="+o.getId()+"\"><img src=\""+o.getImg()+"\" class=\"product-image\"></a>\n" +
                    "                                <h5 class=\"card-title\"><b>Accessory</b></h5>\n" +
                    "                                <p class=\"card-text small\">"+o.getName()+"</p>\n" +
                    "                                <p class=\"tags\">"+o.getPrice()+"</p>\n" +
                    "                                <a href=\"cart-add?id="+o.getId()+"\" target=\"_blank\" class=\"btn btn-success button-text\"><i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i> Add to cart</a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
