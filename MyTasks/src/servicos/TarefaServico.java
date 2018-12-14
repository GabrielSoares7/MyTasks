package servicos;

import dao.TarefaDAO;
import java.util.ArrayList;
import modelo.Tarefa;

public class TarefaServico {
    public static void salvar(Tarefa tarefa) {
        if(tarefa.getId() == 0) 
            new TarefaDAO().insert(tarefa);
        else
            new TarefaDAO().update(tarefa);
    }
    
    public static void delete(Tarefa tarefa) {
        new TarefaDAO().delete(tarefa);
    }
    
    public static ArrayList<Tarefa> carregarTarefas(int fkQuadroId) {
        return new TarefaDAO().findTarefasByQuadroId(fkQuadroId);
    }
}
