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

            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o livro" + ex);
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

                    livro.setTitulo(rs.getString("title"));
                    livro.setIsbn(rs.getString("isbn"));
                    livro.setPublisher_id(rs.getInt("publisher_id"));
                    livro.setPrice(rs.getFloat("price"));
                    livros.add(livro);
                }
                return livros;
            } catch (SQLException ex) {
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
