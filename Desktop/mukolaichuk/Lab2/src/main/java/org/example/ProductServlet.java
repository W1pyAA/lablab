package org.example;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private final Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        // Зберігаємо файл у безпечному місці на сервері
        String path = getServletContext().getRealPath("/WEB-INF/data.json");
        productService = new ProductService(path);
    }

    // Отримання списку (Read)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(gson.toJson(productService.getAll()));
    }

    // Додавання (Create)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CleaningProduct product = gson.fromJson(getRequestBody(req), CleaningProduct.class);
        productService.add(product);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    // Оновлення (Update)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CleaningProduct product = gson.fromJson(getRequestBody(req), CleaningProduct.class);
        productService.update(product);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    // Видалення (Delete)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private String getRequestBody(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}