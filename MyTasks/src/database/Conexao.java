package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    private Connection conexao;
    private String url;
    private String usuario;
    private String senha;
    
    public Conexao() {
        conexao = null;
        url = "jdbc:mysql://localhost/tarefas";
        usuario = "root";
        senha ="";
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, você está desconectado."
                    + "\nTente novamente mais tarde!");
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public Connection getConexao() {
        return conexao;
    } 
}