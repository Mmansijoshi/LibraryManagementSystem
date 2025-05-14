package com.library.servlet;


import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;
import java.util.*;

import com.library.model.Book;
public class BookListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "The Alchemist", "Paulo Coelho", "Fiction"));
        bookList.add(new Book(2, "Atomic Habits", "James Clear", "Self-Help"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the list in application scope if not already present
        ServletContext context = getServletContext();
        if (context.getAttribute("bookList") == null) {
            context.setAttribute("bookList", bookList);
        }

        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}
