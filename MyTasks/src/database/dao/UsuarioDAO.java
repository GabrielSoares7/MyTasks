package database.dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import outros.Usuario;

public class UsuarioDAO {
    private Conexao conexao;
    
    public UsuarioDAO () {
        conexao = new Conexao();
    }
    
    public void insert(Usuario usuario) {
        String insert = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            /*Para inserir de forma mais segura no banco de dados*/
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                "Ocorreu um erro durante o cadastro do usuário: " + ex);
            ex.printStackTrace();
        }
    }
    
    public Usuario validarUsuario(String login, String senha) {
        String select = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                return new Usuario(rs.getInt("id"), 
                        rs.getString("nome"), rs.getString("login"),
                        rs.getString("senha"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na sua conexão com a base de dados!");
            ex.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
