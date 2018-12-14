package modelo;

public class Quadro {
    private int id;
    private String nome;
    private int userId;

    public Quadro(int id, String nome, int userId) {
        this.id = id;
        setNome(nome);
        this.userId = userId;
    }

    public Quadro(String nome, int userId) {
        id = 0;
        setNome(nome);
        this.userId = userId;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty() && nome.length() > 2)
            this.nome = nome;
        else
            throw new RuntimeException("É necessário informar o nome do quadro");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
}
