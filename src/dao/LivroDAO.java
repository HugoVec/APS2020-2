package dao;

import entity.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.DatabaseConnection;

public class LivroDAO {

    Connection conn;
    
    public LivroDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
    public void create(Livro livro) {
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO books (title,publisher_id,price)VALUES(?,?,?)");
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getPublisher_id());
            stmt.setFloat(3, livro.getPrice());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o livro" + ex);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }
}
