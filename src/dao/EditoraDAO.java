package dao;

import entity.Editora;
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

public class EditoraDAO {

    Connection conn;

    public EditoraDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public boolean inserirEditora(Editora editora) {
        String sql = "INSERT INTO publishers (name,url)VALUES(?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getName());
            stmt.setString(2, editora.getUrl());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public List<Editora> listarEditora() {
        String sql = "SELECT * FROM publishers";
        PreparedStatement stmt;
        List<Editora> editoras = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Editora editora = new Editora();

                    editora.setPublisher_id(rs.getInt("publisher_id"));
                    editora.setName(rs.getString("name"));
                    editora.setUrl(rs.getString("url"));
                    editoras.add(editora);
                }
                return editoras;
            } catch (SQLException ex) {
                System.out.println("Failed in listarEditora()");
                Logger.getLogger(EditoraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean editarEditora(Editora editora) {
        String sql = "UPDATE publishers SET name = ?, url = ? WHERE publisher_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getName());
            stmt.setString(2, editora.getUrl());
            stmt.setInt(3, editora.getPublisher_id());

            if (stmt.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public void excluirEditora(Editora editora) {
        String sql = "DELETE FROM publishers where name = ? and url = ?";

        try {
            try ( //Statement stmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, editora.getName());
                pstmt.setString(2, editora.getUrl());
                pstmt.executeUpdate();
            }
            conn.close();

            JOptionPane.showMessageDialog(null, "Editora excluida com sucesso");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
