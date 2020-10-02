package dao;

import entity.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.DatabaseConnection;

public class AutorDAO {

    Connection conn;

    public AutorDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public void create(Autor autor) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO authors (name,fname)VALUES(?,?)");
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getFname());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o autor" + ex);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }
}
