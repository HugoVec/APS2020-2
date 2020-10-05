package dao;

import entity.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void inserirAutor(Autor autor) {
        String sql = "INSERT INTO authors (name,fname)VALUES(?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getFname());

            if (stmt.executeUpdate() > 0) {
                //return true;
            }

            JOptionPane.showMessageDialog(null, "Autor inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o autor" + ex);
        }

        //return false;
    }
    
     public List<Autor> listarAutor() {
        String sql = "SELECT * FROM auhtors";
        PreparedStatement stmt;
        List<Autor> autores = new ArrayList<>();
        if (conn != null) {
            try {
                stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Autor autor = new Autor();

                    autor.setName(rs.getString("Nome"));
                    autor.setFname(rs.getString("Fname"));
                    autores.add(autor);
                }
                return autores;
            } catch (SQLException ex) {
                Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    
    
    public void excluirAutor (Autor autor){
        String sql = "DELETE FROM authors where name = ? and fname= ?";
        
        try {
            try ( //Statement stmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, autor.getName());
                pstmt.setString(2, autor.getFname());
                pstmt.executeUpdate();
            }
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Autor excluido com sucesso");
            

        } catch(SQLException e){
           System.err.println(e.getMessage());
        }
    }
    
    public void modificarAutor(Autor autor){
         String sql = "INSERT INTO authors (name,fname)VALUES(?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getFname());

            if (stmt.executeUpdate() > 0) {
                //return true;
            }

            JOptionPane.showMessageDialog(null, "Autor alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o autor" + ex);
        }

    }
    
    
    
    
}

