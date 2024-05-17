package dao;


import interfaces.IDataAcessObjects;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MunicipioModel;
import modelo.TipoContactoModel;
import modelo.BairroModel;
import modelo.ComboBoxItem;
import modelo.ContactoModel;
/**
 *
 * @author ayrton.antonio
 */
public class ContactoDAO extends DAOHelper implements IDataAcessObjects
{
    
        @Override
    public void Guardar(Object valor) {
        ContactoModel model = (ContactoModel)valor;    
        
        try 
        {
            
            int i=1;
            if(model.getId() == 0)
            {
                sqlQuary = "INSERT INTO Contacto(nome,telefone,whatsapp,email,idTipoContacto,idMunicipio,idBairro) " + 
                        " VALUES (?,?,?,?,?,?,?)";
                preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            }else{
                sqlQuary = "UPDATE Contacto " +
                           " SET nome = ?, "
                            + "   telefone = ?, "
                            + "   whatsapp = ?, "
                            + "   email = ?, "
                            + "   idTipoContacto = ?, "
                            + "   idMunicipio = ?, "
                            + "   idBairro = ? "
                            + " WHERE id = ? ";
                preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            }
                
            preparedStatement.setString(i++, model.getNome());
            preparedStatement.setString(i++, model.getTelefone());
            preparedStatement.setString(i++, model.getWhatsapp());
            preparedStatement.setString(i++, model.getEmail());
            preparedStatement.setInt(i++, model.getIdTipoContacto());
            preparedStatement.setInt(i++, model.getIdMunicipio());
            preparedStatement.setInt(i++, model.getIdBairro());
            
            if(model.getId() != 0)
                preparedStatement.setInt(i++, model.getId());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de base de dados: " + ex.getMessage());
            
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar Guardar registro: " + ex.getMessage());
        }
        
    }

    @Override
    public void Excluir(int id) {
        sqlQuary = "DELETE FROM Contacto WHERE id = ?";
        
        try 
        {
            preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void CarregarComboBox(Object cbo) 
    {
        // Query para selecionar todos os tipos de contato disponíveis
        String sqlQuery = "SELECT id, nome FROM Contacto";
        JComboBox comboBox = (JComboBox)cbo;
        comboBox.addItem(new ComboBoxItem(0, "Selecione..."));
        try {
            preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            // Adicionar os tipos de contato ao ComboBox
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                comboBox.addItem(new ComboBoxItem(id, nome));
            }

            // Fechar recursos
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(TipoContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     *
     * @param valor
     */
    @Override
    public void Consultar(Object... valor)
    {
        if("".equals((String)valor[0])){
            sqlQuary = "SELECT TC.nome as TipoContacto, "
                    + "  BRR.nome AS Bairro, "
                    + "  MP.nome AS Municipio, C.* "
                    + " FROM Contacto C "
                    + "   JOIN TipoContacto TC ON C.idTipoContacto = TC.ID "
                    + "   JOIN Municipio MP ON C.idMunicipio = MP.ID "
                    + "   JOIN Bairro BRR ON C.idBairro = BRR.ID ";
        }else{
            sqlQuary = "SELECT TC.nome as TipoContacto, "
                    + "  BRR.nome AS Bairro, "
                    + "  MP.nome AS Municipio, C.* "
                    + " FROM Contacto C "
                    + "   JOIN TipoContacto TC ON C.idTipoContacto = TC.ID "
                    + "   JOIN Municipio MP ON C.idMunicipio = MP.ID "
                    + "   JOIN Bairro BRR ON C.idBairro = BRR.ID "
                    + " WHERE C.nome LIKE '%" + valor[0].toString() + "%' " 
                    + "   OR  C.telefone LIKE '%" + valor[0].toString() + "%' "
                    + "   OR  C.email LIKE '%" + valor[0].toString() + "%'";
        }
        
        try {
            
            DefaultTableModel tabela = (DefaultTableModel)valor[1];
            
            preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            this.resultSet = preparedStatement.executeQuery();
            //new Object[] {"ID", "Nome","E-mail","Telefone","Whatsapp","Tipo de Contacto"});
            // nome,telefone,whatsapp,email,idTipoContacto,idMunicipio,idBairro
            while (resultSet.next()) {
                tabela.addRow(
                 new Object[]{
                     resultSet.getInt("id"),
                     resultSet.getString("nome"),
                     resultSet.getString("telefone"),                     
                     resultSet.getString("whatsapp"),                     
                     resultSet.getString("email"),                     
                     resultSet.getString("TipoContacto"),                     
                     resultSet.getString("Municipio"),                     
                     resultSet.getString("Bairro")
                         
                 }
                );
                
            }
            
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}