package dao;

import servicos.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import servicos.QuadroServico;

public class UsuarioDAO {
    private final Conexao conexao;
    
    public UsuarioDAO () {
        conexao = new Conexao();
    }
    
    public void insert(Usuario usuario) {
        String insert = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(insert);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro na sua conexão "
                    + "com a base de dados durante o insert!\n"
                    + ex.getMessage());
        }
    }
    
    public Usuario findUsuarioByLoginAndPassword(String login, String senha) {
        String select = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                Usuario usuario = new Usuario(rs.getInt("id"), 
                        rs.getString("nome"), rs.getString("login"),
                        rs.getString("senha"));
                usuario.setQuadros(QuadroServico.retornarQuadros(usuario));
                return usuario;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro na sua conexão "
                    + "com a base de dados!\n"
                    + ex.getMessage());
        }
        return null;
    }
    
    public Usuario findUsuarioByLogin(String login) {
        String select = "SELECT * FROM usuarios WHERE login = ?";
        
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(select);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()) {
                Usuario usuario = new Usuario(rs.getInt("id"), 
                        rs.getString("nome"), rs.getString("login"),
                        rs.getString("senha"));
                usuario.setQuadros(QuadroServico.retornarQuadros(usuario));
                return usuario;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro na sua conexão "
                    + "com a base de dados!\n"
                    + ex.getMessage());
        }
        return null;
    }
}
