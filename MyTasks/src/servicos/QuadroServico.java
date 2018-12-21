package servicos;

import dao.QuadroDAO;
import java.util.ArrayList;
import modelo.Quadro;
import modelo.Usuario;

public class QuadroServico {
    
    public static void salvar(Quadro quadro, Usuario usuario) {
        if(quadro.getId() == 0) {
            ArrayList <Quadro> quadros = retornarQuadros(usuario);
            for(Quadro q : quadros) {
                if(quadro.getNome().equals(q.getNome())) {
                    throw new RuntimeException("Já Existe um quadro com este mesmo nome");
                }
            }
            new QuadroDAO().insert(quadro, usuario.getId());
        }
        else
            new QuadroDAO().update(quadro);
    }
    
    public static ArrayList<Quadro> retornarQuadros(Usuario usuario) {
        return new QuadroDAO().findQuadrosByUserId(usuario);
    }
    
    public static void deletarQuadro(Quadro quadro) {
        for(modelo.Tarefa tarefa : quadro.getTarefas()) {
            TarefaServico.delete(tarefa);
        }
        
        new QuadroDAO().deleteQuadroById(quadro.getId());
    }
    
    
}
