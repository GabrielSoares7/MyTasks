package outros;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        setLogin(login);
        setSenha(senha);
    }

    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
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
        if(!login.isEmpty() && login.length() >= 2)
            this.login = login;
        else
            throw new RuntimeException("Digite um login!");
        
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        if(senha.length() < 8)
            throw new RuntimeException("Digite uma senha com no mínimo 8 caracteres!");
        else
            this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
