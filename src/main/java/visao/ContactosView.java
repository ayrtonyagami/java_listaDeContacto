package visao;

import controle.ContactoController;
import controle.MunicipioController;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBoxItem;

/**
 * @author ayrton.antonio
 */
public class ContactosView extends FormPadrao{
    
    JLabel jlblTelefone;
    JTextField jtxtTelefone;
    
    JLabel jlblWhatsapp;
    JTextField jtxtWhatsapp;
    private JLabel jlblEmail;
    private JTextField jtxtEmail;
    private JLabel jlblTipoContacto;
    private JComboBox jcbxTipoContacto;
    private JLabel jlblMunicipio;
    private JComboBox jcbxMunicipio;
    private JLabel jlblBairro;
    private JComboBox jcbxBairro;
    
    ContactoController contController = new ContactoController();
    
    public ContactosView(){
        setTitle("Contactos");
        
        ConsultarView();
        
        contController.CarregarTipoContactoComboBox(jcbxTipoContacto);
        contController.CarregarMunicipiosComboBox(jcbxMunicipio);
        contController.CarregarBairrosComboBox(jcbxBairro,0);
        
        Internationalizar();
    }

    @Override
    void inicializacaoComponentesFilho() 
    {
        jlblTelefone = new JLabel("Telefone");
        jlblTelefone.setBounds(40, 70, 140, 25);
        jpnFormulario.add(jlblTelefone);
                
        jtxtTelefone = new JTextField();
        jtxtTelefone.setBounds(40, 90, 150, 25);
        jpnFormulario.add(jtxtTelefone);
        
        jlblWhatsapp = new JLabel("Whatsapp");
        jlblWhatsapp.setBounds(210, 70, 140, 25);
        jpnFormulario.add(jlblWhatsapp);
                
        jtxtWhatsapp = new JTextField();
        jtxtWhatsapp.setBounds(210, 90, 150, 25);
        jpnFormulario.add(jtxtWhatsapp);        
        
        jlblEmail = new JLabel("E-mail");
        jlblEmail.setBounds(380, 70, 140, 25);
        jpnFormulario.add(jlblEmail);
                
        jtxtEmail = new JTextField();
        jtxtEmail.setBounds(380, 90, 320, 25);
        jpnFormulario.add(jtxtEmail);
        
        // Linha 3
        jlblTipoContacto = new JLabel("Tipo");
        jlblTipoContacto.setBounds(40, 120, 140, 25);
        jpnFormulario.add(jlblTipoContacto);
                
        jcbxTipoContacto = new JComboBox();
        jcbxTipoContacto.setBounds(40, 140, 150, 25);
        jpnFormulario.add(jcbxTipoContacto);
        
        jlblMunicipio = new JLabel("Município");
        jlblMunicipio.setBounds(210, 120, 140, 25);
        jpnFormulario.add(jlblMunicipio);
                
        jcbxMunicipio = new JComboBox();
        jcbxMunicipio.setBounds(210, 140, 150, 25);
        jpnFormulario.add(jcbxMunicipio);   
        
         jcbxMunicipio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jcbxBairro.removeAllItems();
                    ComboBoxItem selectedMunicipio = (ComboBoxItem) jcbxMunicipio.getSelectedItem();
                    contController.CarregarBairrosComboBox(jcbxBairro,selectedMunicipio.getId());
                }
            }
        });
        
        jlblBairro = new JLabel("Bairro");
        jlblBairro.setBounds(380, 120, 60, 25);
        jpnFormulario.add(jlblBairro);
                
        jcbxBairro = new JComboBox();
        jcbxBairro.setBounds(380, 140, 320, 25);
        jpnFormulario.add(jcbxBairro);       
        
        
    }

    @Override
    void Guardar() {
        
        ComboBoxItem cboTipoContacto = (ComboBoxItem)jcbxTipoContacto.getSelectedItem();
        ComboBoxItem cboMunicipio = (ComboBoxItem)jcbxMunicipio.getSelectedItem();
        ComboBoxItem cboBairro = (ComboBoxItem)jcbxBairro.getSelectedItem();
        
        contController.Guardar(
                txtID.getText(), 
                txtDescricao.getText(),
                jtxtTelefone.getText(),
                jtxtWhatsapp.getText(),
                jtxtEmail.getText(), 
                cboTipoContacto.getId(),
                cboMunicipio.getId(),
                cboBairro.getId()
        );
    }

    
    @Override
    void CriarTabela() {
        tabela = utilTabela.criarTabela(
                jpnConsulta, 
                new Object[] {40,170,120,100,100,100,100,100}, 
                new Object[] {"centro","esquerda","esquerda","esquerda","esquerda","esquerda","esquerda","esquerda"},
                new Object[] {messages.getString("campo.Id"), 
                    messages.getString("campo.Name"),
                    messages.getString("campo.Telephone"),
                    messages.getString("campo.Whatsapp"),
                    messages.getString("campo.Email"),
                    messages.getString("campo.Typesontacts"),
                    messages.getString("campo.Counties"),
                    messages.getString("campo.Neighborhoods")
                });
        
        model = (DefaultTableModel)tabela.getModel();
    }

    @Override
    void ConsultarView() {
        model.setNumRows(0);
        contController.Consultar(jtxtConsulta.getText(), this.model);
    }
    
    @Override
    public void LimparCampos(){
        txtID.setText("");        
        txtDescricao.setText("");  
        jtxtTelefone.setText("");
        jtxtWhatsapp.setText("");
        jtxtEmail.setText("");
        jcbxTipoContacto.setSelectedIndex(0);
        jcbxMunicipio.setSelectedIndex(0);
        jcbxBairro.setSelectedIndex(0);
    }

    @Override
    void ActualizarFormulario() {
        int linha = tabela.getSelectedRow();
        int colID = 0;        
        int colNome = 1;        
        int colTelefone = 2;
        int colWhatsapp = 3;
        int colEmail = 4;
        int colTipo = 5;
        int colMunicipio = 6;
        int colBairro = 7;

        txtID.setText((String)tabela.getValueAt(linha, colID).toString());
        txtDescricao.setText((String)tabela.getValueAt(linha, colNome).toString());
        jtxtTelefone.setText((String)tabela.getValueAt(linha, colTelefone).toString());
        jtxtWhatsapp.setText((String)tabela.getValueAt(linha, colWhatsapp).toString());
        jtxtEmail.setText((String)tabela.getValueAt(linha, colEmail).toString());
        
        SelecionarItemComboBoxPorNome(jcbxTipoContacto,tabela.getValueAt(linha, colTipo).toString());        
        SelecionarItemComboBoxPorNome(jcbxMunicipio,tabela.getValueAt(linha, colMunicipio).toString());        
        SelecionarItemComboBoxPorNome(jcbxBairro,tabela.getValueAt(linha, colBairro).toString());
        
    }

    @Override
    void ExcluirView() {
        int id = Integer.parseInt(txtID.getText());
        contController.Excluir(id);
    }
    
    @Override
    public void Internationalizar() {
        // Carrega o ResourceBundle padrão (inglês)
        jLabelID.setText(messages.getString("campo.Id"));
        jLabelDescricao.setText(messages.getString("campo.Description"));
        jlblTelefone.setText(messages.getString("campo.Telephone"));
        jlblWhatsapp.setText(messages.getString("campo.Whatsapp"));
        jlblEmail.setText(messages.getString("campo.Email"));
        jlblTipoContacto.setText(messages.getString("campo.Typesontacts"));
        jlblMunicipio.setText(messages.getString("campo.Counties"));
        jlblBairro.setText(messages.getString("campo.Neighborhoods"));
        jlblConsulta.setText(messages.getString("campo.Query"));        
    }
    
}
