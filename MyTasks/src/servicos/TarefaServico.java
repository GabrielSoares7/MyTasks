package servicos;

import dao.TarefaDAO;
import java.util.ArrayList;
import modelo.Quadro;
import modelo.Tarefa;

public class TarefaServico {
    public static void salvar(Tarefa tarefa, Quadro quadroDaTarefa) {
        if(tarefa.getId() == 0) 
            new TarefaDAO().insert(tarefa, quadroDaTarefa.getId());
        else
            new TarefaDAO().update(tarefa);
    }
    
    public static void delete(Tarefa tarefa) {
        new TarefaDAO().delete(tarefa);
    }
    
    public static ArrayList<Tarefa> carregarTarefasPorQuadro (Quadro quadro) {
        return new TarefaDAO().findTarefasByQuadroId(quadro);
    }
}
