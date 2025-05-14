
package com.library.dao;

import java.sql.*;
import java.util.*;
import com.library.model.Book;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "011203";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?;";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertBook(Book book) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT_BOOK_SQL)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.executeUpdate();
        }
    }

    public List<Book> selectAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre")));
            }
        }
        return books;
    }

    public void deleteBook(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_BOOK_SQL)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
