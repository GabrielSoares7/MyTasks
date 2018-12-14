package modelo;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha) {
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }

    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        setNome(nome);
        setLogin(login);
        setSenha(senha);
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
}
