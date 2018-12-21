package modelo;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private boolean feito;

    public Tarefa(int id, String titulo, String descricao, boolean feito) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.feito = feito;
    }

    public Tarefa(String titulo, String descricao, boolean feito) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.feito = feito;
    }

    public Tarefa() {
        id = 0;
        feito = false;
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
