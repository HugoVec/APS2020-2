package dao;

import entity.Autor;
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

public class AutorDAO {

    Connection conn;

    public AutorDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public boolean inserirAutor(Autor autor) {
        String sql = "INSERT INTO authors (name,fname)VALUES(?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getFname());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    public List<Autor> listarAutor() {
        String sql = "SELECT * FROM authors";
        PreparedStatement stmt;
        List<Autor> autores = new ArrayList<>();

        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Autor autor = new Autor();

                    autor.setAuthor_id(rs.getInt("author_id"));
                    autor.setFname(rs.getString("fname"));
                    autor.setName(rs.getString("name"));

                    autores.add(autor);
                }
                return autores;
            } catch (SQLException ex) {
                System.out.println("Failed in listarAutor()");
                Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public boolean editarAutor(Autor autor) {
        String sql = "UPDATE authors SET name = ?, fname = ? WHERE author_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getFname());
            stmt.setInt(3, autor.getAuthor_id());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean excluirAutor(Autor autor) {
        String sql = "DELETE FROM authors WHERE author_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autor.getAuthor_id());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
