package modelo;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private boolean feito;
    private int quadroId;

    public Tarefa(int id, String titulo, String descricao, boolean feito, int quadroId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.feito = feito;
        this.quadroId = quadroId;
    }

    public Tarefa(String titulo, String descricao, boolean feito, int quadroId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.feito = feito;
        this.quadroId = quadroId;
    }

    public Tarefa(int quadroId) {
        this.quadroId = quadroId;
    }
    
    public int getQuadroId() {
        return quadroId;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }
    
    public void setFeito() {
        this.feito = !feito;
    }
}
