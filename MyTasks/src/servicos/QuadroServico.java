package servicos;

import dao.QuadroDAO;
import java.util.ArrayList;
import modelo.Quadro;

public class QuadroServico {
    
    public static void salvar(Quadro quadro) {
        if(quadro.getId() == 0)
            new QuadroDAO().insert(quadro);
        else
            new QuadroDAO().update(quadro);
    }
    
    public static ArrayList<Quadro> retornarQuadros(int userId) {
        return new QuadroDAO().findQuadrosByUserId(userId);
    }
    
    public static void deletarQuadro(Quadro quadro) {
        new QuadroDAO().deleteQuadroById(quadro.getId());
    }
    
}
