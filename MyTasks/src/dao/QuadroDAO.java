
package dao;

import servicos.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Quadro;
import modelo.Usuario;
import servicos.TarefaServico;

public class QuadroDAO {
    
    private Conexao conexao;
    
    public QuadroDAO() {
        conexao = new Conexao();
    }
    
    public void insert(Quadro quadro, int usuarioId) {
        String insert = "INSERT INTO quadros (nome, user_id) VALUES (?, ?)";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setString(1, quadro.getNome());
            stmt.setInt(2, usuarioId);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a"
                    + " execução do 'insert'!\n"
                    + ex.getMessage());
        }
    }
    
    public ArrayList<Quadro> findQuadrosByUserId(Usuario usuario) {
        String select = "SELECT id, nome, user_id FROM quadros WHERE user_id = ?";
        ArrayList<Quadro> quadros = new ArrayList<> ();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setInt(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                do {
                    quadros.add(new Quadro(rs.getInt("id"),
                            rs.getString("nome")));
                    
                    int i = quadros.size() - 1;
                    quadros.get(i).setTarefas(TarefaServico
                            .carregarTarefasPorQuadro(quadros.get(i)));
                }while(rs.next());
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a busca!\n"
                    + ex.getMessage());
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
            throw new RuntimeException("Ocorreu um erro durante a exclusão!\n"
                    + ex.getMessage());
        }
    }
    
    public void update(Quadro quadro) {
        String insert = "UPDATE quadros SET nome=? WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setString(1, quadro.getNome());
            stmt.setInt(2, quadro.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a"
                    + " execução do 'update'!\n"
                    + ex.getMessage());
        }
    }
}
