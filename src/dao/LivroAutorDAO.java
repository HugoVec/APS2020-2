package dao;

import entity.LivroAutor;
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

public class LivroAutorDAO {

    Connection conn;

    public LivroAutorDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public boolean inserirLivroAutor(LivroAutor livroAutor) {
        String sql = "INSERT INTO booksauthors (seq_no)VALUES(?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, livroAutor.getSeq_no());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public List<LivroAutor> listarLivroAutor() {
        String sql = "SELECT * FROM booksauthors";
        PreparedStatement stmt;
        List<LivroAutor> livrosAutores = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    LivroAutor livroAutor = new LivroAutor();

                    livroAutor.setIsbn(rs.getString("isbn"));
                    livroAutor.setAuthor_id(rs.getInt("author_id"));
                    livroAutor.setSeq_no(rs.getInt("seq_no"));
                    livrosAutores.add(livroAutor);
                }
                return livrosAutores;
            } catch (SQLException ex) {
                System.out.println("Failed in listarLivroAutor()");
                Logger.getLogger(LivroAutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean editarLivroAutor(LivroAutor livroAutor) {
        String sql = "UPDATE booksauthors SET seq_no = ? WHERE isbn = ?, author_id = ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(2, livroAutor.getIsbn());
            stmt.setInt(1, livroAutor.getSeq_no());
            stmt.setInt(3, livroAutor.getAuthor_id());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public void excluirLivroAutor(LivroAutor livroAutor) {
        String sql = "DELETE FROM booksauthors where isbn=?";

        try {
            try ( //Statement stmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, livroAutor.getIsbn());
                pstmt.executeUpdate();
            }
            conn.close();

            JOptionPane.showMessageDialog(null, "Livro Excluido com sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
