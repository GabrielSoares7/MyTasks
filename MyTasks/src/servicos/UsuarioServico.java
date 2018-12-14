package servicos;

import dao.UsuarioDAO;
import javax.swing.JTextField;
import modelo.Usuario;

public class UsuarioServico {
    public static void salvar(String nome, String login, String senha) {
        Usuario usuario = new Usuario(nome, login, senha);
        new UsuarioDAO().insert(usuario);
    }
    
    public static boolean isLoginValido(String login, String password) {
        if(login.isEmpty())
            return false;
        return new UsuarioDAO()
                .findUsuarioByLoginAndPassword(login, password) != null;
    }
    
    public static Usuario buscarUsuarioPorLogin(String login) {
        return new UsuarioDAO().findUsuarioByLogin(login);
    }
    
    public static boolean isLoginDisponivel(String login) {
        login = login.trim();
        if(!login.isEmpty() && login.length() >= 3 &&
                login.split(" ").length <= 1)
            return false;
        else {
            return buscarUsuarioPorLogin(login) != null;
        }
    }

    public static boolean isLoginDisponivel(JTextField jLoginTextField) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
