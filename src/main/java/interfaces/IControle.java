package interfaces;

/**
 *
 * @author ayrton.antonio
 */
public interface IControle {
    public void Guardar(Object... valor);
    public void Excluir(int id);
    public void CarregarComboBox(Object cbo);
    public void Consultar(Object... valor);
}
