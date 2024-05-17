package visao;

import controle.TipoContactoController;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayrton.antonio
 */
public class TiposContactosView extends FormPadrao
{
    TipoContactoController tcController = new TipoContactoController();
    public TiposContactosView(){
        setTitle("Cadastro de Tipos de Contactos");
        
        ConsultarView();
    }

    @Override
    void inicializacaoComponentesFilho() {
        
    }

    @Override
    void Guardar() {
        tcController.Guardar(txtID.getText(), txtDescricao.getText());
    }

    @Override
    void CriarTabela() {
        
        tabela = utilTabela.criarTabela(
                jpnConsulta, 
                new Object[] {60,600}, 
                new Object[] {"centro","esquerda"},
                new Object[] {"ID", "Descrição"});
        
        model = (DefaultTableModel)tabela.getModel();
    }

    @Override
    void ConsultarView() {
        model.setNumRows(0);
        tcController.Consultar(jtxtConsulta.getText(), this.model);
    }

    @Override
    void ActualizarFormulario() {
        int linha = tabela.getSelectedRow();
        int colID = 0;        
        int colDescricao = 1;

        txtID.setText((String)tabela.getValueAt(linha, colID).toString());
        txtDescricao.setText((String)tabela.getValueAt(linha, colDescricao).toString());
        
    }

    @Override
    void ExcluirView() {
        int id = Integer.parseInt(txtID.getText());
        tcController.Excluir(id);
    }
}
