package com.library.servlet;

import com.library.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idToDelete = Integer.parseInt(request.getParameter("id"));
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");

        if (bookList != null) {
            bookList.removeIf(book -> book.getId() == idToDelete);
        }

        response.sendRedirect("bookList");
    }
}
