package modelo;

import java.util.ArrayList;

public class Quadro {
    private int id;
    private String nome;
    private ArrayList<Tarefa> tarefas;

    public Quadro(int id, String nome, ArrayList <Tarefa> tarefas) {
        this.id = id;
        setNome(nome);
        this.tarefas = tarefas;
    }

    public Quadro(int id, String nome) {
        this.id = id;
        setNome(nome);
        this.tarefas = new ArrayList<>();
    }
    
    public Quadro(String nome) {
        id = 0;
        setNome(nome);
        this.tarefas = new ArrayList<>();
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

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    } 

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
