/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

import controle.MunicipioController;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ayrton.antonio
 */
public class MunicipioView extends FormPadrao
{
    JLabel jlblProvincia;
    JComboBox jcbProvincia;
    
    MunicipioController muController = new MunicipioController();
    
    public MunicipioView(){
        setTitle("Cadastro de Municípios");        
        
        ConsultarView();
    }

    @Override
    void inicializacaoComponentesFilho() {
        
        jlblProvincia = new JLabel("Provincia");
        jlblProvincia.setBounds(40, 80, 60, 25);
        jpnFormulario.add(jlblProvincia);
        
        jcbProvincia = new JComboBox();
        jcbProvincia.setBounds(40, 100, 460, 25);
        
        jcbProvincia.addItem("Bengo");
        jcbProvincia.addItem("Benguela");
        jcbProvincia.addItem("Bié");
        jcbProvincia.addItem("Cabinda");
        jcbProvincia.addItem("Cuando Cubango");
        jcbProvincia.addItem("Cuanza Norte");
        jcbProvincia.addItem("Cuanza Sul");
        jcbProvincia.addItem("Cunene");
        jcbProvincia.addItem("Huambo");
        jcbProvincia.addItem("Huíla");
        jcbProvincia.addItem("Luanda");
        jcbProvincia.addItem("Lunda Norte");
        jcbProvincia.addItem("Lunda Sul");
        jcbProvincia.addItem("Malanje");
        jcbProvincia.addItem("Moxico");
        jcbProvincia.addItem("Namibe");
        jcbProvincia.addItem("Uíge");
        jcbProvincia.addItem("Zaire");
        
        jpnFormulario.add(jcbProvincia);
    }

    @Override
    void Guardar() {
        muController.Guardar(txtID.getText(), txtDescricao.getText(), jcbProvincia.getSelectedItem());
    }

    @Override
    public void LimparCampos(){
        txtID.setText("");        
        txtDescricao.setText("");  
        jcbProvincia.setSelectedIndex(0);
    }
    
    @Override
    void CriarTabela() {
        
        tabela = utilTabela.criarTabela(
                jpnConsulta, 
                new Object[] {40,350,300}, 
                new Object[] {"centro","esquerda","esquerda"},
                new Object[] {"ID", "Descrição","Provincia"});
        
        model = (DefaultTableModel)tabela.getModel();
    }

    @Override
    void ConsultarView() {
        model.setNumRows(0);
        muController.Consultar(jtxtConsulta.getText(), this.model);
    }

    @Override
    void ActualizarFormulario() {
        int linha = tabela.getSelectedRow();
        int colID = 0;        
        int colDescricao = 1;        
        int colProvincia = 2;


        txtID.setText((String)tabela.getValueAt(linha, colID).toString());
        txtDescricao.setText((String)tabela.getValueAt(linha, colDescricao).toString());
        jcbProvincia.setSelectedItem((String)tabela.getValueAt(linha, colProvincia).toString());
        
    }

    @Override
    void ExcluirView() {
        int id = Integer.parseInt(txtID.getText());
        muController.Excluir(id);
    }
}
