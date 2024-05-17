package interfaces;

import dao.DAOHelper;

/**
 *
 * @author ayrton.antonio
 */
public interface IDataAcessObjects
{
    
    public void Guardar(Object valor);
    public void Excluir(int id);
    public void CarregarComboBox(Object cbo);
    public void Consultar(Object... valor);
    
    
}
