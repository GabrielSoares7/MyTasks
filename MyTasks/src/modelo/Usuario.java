package modelo;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private ArrayList<Quadro> quadros;

    public Usuario(String nome, String login, String senha) {
        setNome(nome);
        setLogin(login);
        setSenha(senha);
        quadros = new ArrayList<>();
    }

    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        setNome(nome);
        setLogin(login);
        setSenha(senha);
        this.quadros = new ArrayList<>();
    }
    
    public Usuario(int id, String nome, String login, String senha, ArrayList<Quadro> quadros) {
        this.id = id;
        setNome(nome);
        setLogin(login);
        setSenha(senha);
        this.quadros = quadros;
    }

    public int getId() {
        return id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        login = login.trim();
        if(!login.isEmpty() && login.length() >= 2)
            this.login = login;
        else
            throw new RuntimeException("Login inválido!");
        
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        if(senha.length() < 8)
            throw new RuntimeException("Uma senha com no mínimo 8 caracteres "
                    + "precisa ser informada!");
        else
            this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new RuntimeException("Um nome precisa ser informado!");
        else
            this.nome = nome;
    }

    public ArrayList<Quadro> getQuadros() {
        return quadros;
    }

    public void setQuadros(ArrayList<Quadro> quadros) {
        this.quadros = quadros;
    }
}
