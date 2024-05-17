package controle;

import dao.TipoContactoDAO;
import interfaces.IControle;
import modelo.TipoContactoModel;

/**
 *
 * @author ayrton.antonio
 */
public class TipoContactoController implements IControle
{
    TipoContactoDAO dataAcess = new TipoContactoDAO();
        
        
    @Override
    public void Guardar(Object... valor) {
        TipoContactoModel model = new TipoContactoModel();
        if("".equals(valor[0])){
            model.setId(0);
        }else{
            model.setId(Integer.parseInt(valor[0].toString()));        
        }
        
        model.setDescricao(valor[1].toString());

        dataAcess.Guardar(model);
    }

    @Override
    public void Excluir(int id) {
        dataAcess.Excluir(id);
    }

    @Override
    public void CarregarComboBox(Object cbo) {
        dataAcess.CarregarComboBox(cbo);
    }

    @Override
    public void Consultar(Object... valor) {
        dataAcess.Consultar(valor);
    }
    
}
