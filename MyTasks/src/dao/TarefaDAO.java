package dao;

import servicos.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Tarefa;

public class TarefaDAO {
    private Conexao conexao;
    
    public TarefaDAO() {
        conexao = new Conexao();
    }
    
    public void insert(Tarefa tarefa) {
        String insert = "INSERT INTO tarefas (titulo, descricao,"
                + " feito, quadro_id) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.isFeito());
            stmt.setInt(4, tarefa.getQuadroId());
            stmt.execute();
            stmt.close();
            
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a"
                    + " execução do 'insert'!\n"
                    + ex.getMessage());
        }
    }
    
    public void delete(Tarefa tarefa) {
        String delete = "DELETE FROM tarefas WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(delete);
            stmt.setInt(1, tarefa.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a exclusão!\n"
                    + ex.getMessage());
        }
    }
    
    public ArrayList<Tarefa> findTarefasByQuadroId(int quadroId) {
        String select = "SELECT id, titulo, descricao, feito, quadro_id "
                + "FROM tarefas WHERE quadro_id = ?";
        ArrayList<Tarefa> tarefas = new ArrayList<> ();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setInt(1, quadroId);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                do {
                    tarefas.add(new Tarefa(rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getBoolean("feito"),
                            rs.getInt("quadro_id")));
                }while(rs.next());
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a busca!\n"
                    + ex.getMessage());
        }
        return tarefas;
    }
    
    public void update(Tarefa tarefa) {
        String update = "UPDATE tarefas SET titulo=?, descricao=?, feito=? WHERE id=?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(update);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setBoolean(3, tarefa.isFeito());
            stmt.setInt(4, tarefa.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro durante a atualização!\n"
                    + ex.getMessage());
        }
    }
}
