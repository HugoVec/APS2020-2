package dao;

import entity.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.DatabaseConnection;

public class EditoraDAO {
    
    Connection conn;
    
    public EditoraDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
    public void create(Editora editora) {
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO publishers (name,url)VALUES(?,?)");
            stmt.setString(1, editora.getName());
            stmt.setString(2, editora.getUrl());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editora inserida com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir editora" + ex);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }
}
