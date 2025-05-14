<%@ page import="java.util.*,com.library.model.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head><title>Book List</title></head>
<body>
    <h1>Library Book List</h1>
    <table border="1">
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Genre</th><th>Action</th></tr>
        <%
            List<Book> list = (List<Book>) request.getAttribute("bookList");
            for (Book book : list) {
        %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getGenre() %></td>
                <td><a href="delete?id=<%=book.getId()%>">Delete</a></td>
            </tr>
        <% } %>
    </table>
    <a href="addBook.html">Add More Books</a>
</body>
</html>
