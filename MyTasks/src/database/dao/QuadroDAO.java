
package database.dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import outros.Quadro;
import outros.Usuario;

public class QuadroDAO {
    
    private Conexao conexao;
    
    public QuadroDAO() {
        conexao = new Conexao();
    }
    
    public void insert(Quadro quadro) {
        String insert = "INSERT INTO quadros (nome, user_id) VALUES (?, ?)";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setString(1, quadro.getNome());
            stmt.setInt(2, quadro.getUserId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Ocorreu um erro durante a inserção na base de dados: " + ex);
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Quadro> findQuadrosByUserId(int userId) {
        String select = "SELECT id, nome, user_id FROM quadros WHERE user_id = ?";
        ArrayList<Quadro> quadros = new ArrayList<> ();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                do {
                    quadros.add(new Quadro(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("user_id")));
                }while(rs.next());
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na sua conexão com a base de dados!");
            ex.printStackTrace();
            System.exit(0);
        }
        return quadros;
    }
    
    public void deleteQuadroById(int quadroId) {
        String insert = "DELETE FROM quadros WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setInt(1, quadroId);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Ocorreu um erro durante a exclusão da base de dados: " + ex);
            ex.printStackTrace();
        }
    }
}
