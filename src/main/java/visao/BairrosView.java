/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

import controle.BairroController;
import controle.ContactoController;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBoxItem;

/**
 *
 * @author ayrton.antonio
 */
public class BairrosView extends FormPadrao
{
    JLabel jlblBairro;
    JComboBox jcbBairro;
    BairroController bairroController = new BairroController();
    public BairrosView(){
        setTitle("Cadastro de Bairros");
        
        ConsultarView(); 
        bairroController.CarregarMunicipiosComboBox(jcbBairro);
    }

    @Override
    void inicializacaoComponentesFilho() {
        jlblBairro = new JLabel("Município");
        jlblBairro.setBounds(40, 80, 60, 25);
        jpnFormulario.add(jlblBairro);
        
        jcbBairro = new JComboBox();
        jcbBairro.setBounds(40, 100, 260, 25);
        jpnFormulario.add(jcbBairro);
    }

    @Override
    void Guardar() {
        
        ComboBoxItem cboMunicipio = (ComboBoxItem)jcbBairro.getSelectedItem();
        
        bairroController.Guardar(
                txtID.getText(), 
                txtDescricao.getText(),
                cboMunicipio.getId()
        );
    }

    @Override
    void CriarTabela() {
        tabela = utilTabela.criarTabela(
                jpnConsulta, 
                new Object[] {60,300,150,150}, 
                new Object[] {"centro","esquerda","esquerda","esquerda"},
                new Object[] {"ID", "Nome","Município","Provincia"});
        
        model = (DefaultTableModel)tabela.getModel();
    }

    @Override
    void ConsultarView() {
        model.setNumRows(0);
        bairroController.Consultar(jtxtConsulta.getText(), this.model);
    }

    @Override
    void ActualizarFormulario() {
        int linha = tabela.getSelectedRow();
        int colID = 0;        
        int colNome = 1;        
        int colMunicipio = 2;

        txtID.setText((String)tabela.getValueAt(linha, colID).toString());
        txtDescricao.setText((String)tabela.getValueAt(linha, colNome).toString());               
        SelecionarItemComboBoxPorNome(jcbBairro,tabela.getValueAt(linha, colMunicipio).toString());   
    }

    @Override
    void ExcluirView() {
        int id = Integer.parseInt(txtID.getText());
        bairroController.Excluir(id);
    }
}