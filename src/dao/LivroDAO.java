package dao;

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
        String sql = "INSERT INTO books (title,publisher_id,price)VALUES(?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getPublisher_id());
            stmt.setFloat(3, livro.getPrice());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public List<Livro> listarLivro() {
        String sql = "SELECT * FROM books";
        PreparedStatement stmt;
        List<Livro> livros = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Livro livro = new Livro();

                    
                    livro.setIsbn(rs.getString("isbn"));
                    livro.setTitulo(rs.getString("title"));
                    livro.setPublisher_id(rs.getInt("publisher_id"));
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
        String sql = "UPDATE books SET title = ?, publisher_id = ?, price = ? WHERE isbn = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getPublisher_id());
            stmt.setFloat(3, livro.getPrice());
            stmt.setString(4, livro.getIsbn());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public void excluirLivro(Livro livro) {
        String sql = "DELETE FROM books where isbn=?";

        try {
            try ( //Statement stmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, livro.getIsbn());
                pstmt.executeUpdate();
            }
            conn.close();

            JOptionPane.showMessageDialog(null, "Livro Excluido com sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
