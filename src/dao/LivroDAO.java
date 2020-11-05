package dao;

import entity.Editora;
import entity.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.DatabaseConnection;

public class LivroDAO {

    Connection conn;

    public LivroDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public boolean inserirLivro(Livro livro) {
        String sql = "INSERT INTO books (title,isbn,publisher_id,price)VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getPublisher_id().getPublisher_id());
            stmt.setFloat(4, livro.getPrice());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public List<Livro> listarLivro() {
        String sql = "SELECT b.title, b.isbn, pub.name AS publisher_id, b.price "
                + "FROM books AS b JOIN publishers AS pub ON (b.publisher_id = pub.publisher_id)";
        PreparedStatement stmt;
        List<Livro> livros = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Livro livro = new Livro();
                    Editora editora = new Editora();
                    
                    editora.setName(rs.getString("publisher_id"));

                    livro.setTitulo(rs.getString("title"));
                    livro.setIsbn(rs.getString("isbn"));
                    livro.setPublisher_id(editora);
                    livro.setPrice(rs.getFloat("price"));
                    livros.add(livro);
                }
                return livros;
            } catch (SQLException ex) {
                System.out.println("Failed in listarLivro()");
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public List<Livro> pesquisarLivro(String descricao, String desc, float num) {

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Livro> livros = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement("SELECT * FROM books "
                        + "WHERE title = ? OR isbn = ? OR price = ?");
                stmt.setString(1, "%" + descricao + "%");
                stmt.setString(2, "%" + desc + "%");
                stmt.setString(3, "%" + num + "%");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Livro livro = new Livro();
                    //Editora editora = new Editora();
                    
                    //editora.setName(rs.getString("publisher_id"));
                    livro.setTitulo(rs.getString("title"));
                    livro.setIsbn(rs.getString("isbn"));
                    //livro.setPublisher_id(editora);
                    livro.setPrice(rs.getFloat("price"));
                    livros.add(livro);
                }
                return livros;
            } catch (SQLException ex) {
                System.out.println("Failed in listarLivro()");
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean editarLivro(Livro livro) {
        String sql = "UPDATE books SET title = ?, isbn = ?, publisher_id = ?, price = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getPublisher_id().getPublisher_id());
            stmt.setFloat(4, livro.getPrice());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean excluirLivro(Livro livro) {
        String sql = "DELETE FROM books WHERE isbn = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
