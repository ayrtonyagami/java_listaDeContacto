package dao;


import interfaces.IDataAcessObjects;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ComboBoxItem;
import modelo.BairroModel;


/**
 *
 * @author ayrton.antonio
 */
public class BairroDAO  extends DAOHelper implements IDataAcessObjects
{
    
        @Override
    public void Guardar(Object valor) {
        BairroModel model = (BairroModel)valor;    
        
        try 
        {
            int i=1;
            if(model.getId() == 0)
            {
                this.sqlQuary = "INSERT INTO Bairro(nome,idMunicipio) VALUES (?,?) ";
                this.preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            }else{
                sqlQuary = "UPDATE Bairro "
                        + " SET nome = ? ,"
                        + "   idMunicipio = ? "
                        + " WHERE id = ? ";
                this.preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            }
            
            this.preparedStatement.setString(i++, model.getNome());
            this.preparedStatement.setInt(i++, model.getIdMunicipio());
            
            if(model.getId() != 0)
                this.preparedStatement.setInt(i++, model.getId());
            
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
        sqlQuary = "DELETE FROM Bairro WHERE id = ?";
        
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
        String sqlQuery = "SELECT id, nome FROM Bairro";
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
        
    public void CarregarComboBox(Object cbo, int idMunicipio) 
    {
        // Query para selecionar todos os tipos de contato disponíveis
        String sqlQuery = "SELECT id, nome FROM Bairro WHERE idMunicipio = ?";
        JComboBox comboBox = (JComboBox)cbo;
        comboBox.addItem(new ComboBoxItem(0, "Selecione..."));
        try {
            preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, idMunicipio);
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
        if("".equals((String)valor[0]))
        {
            sqlQuary = " SELECT MP.nome Municipio, MP.provincia, BRR.*"
                    + " FROM Bairro BRR "
                    + "   JOIN MUNICIPIO MP ON BRR.idMunicipio = MP.id ";
            
        }
        else
        {
            sqlQuary = " SELECT MP.nome Municipio, MP.provincia, BRR.*"
                    + " FROM Bairro BRR "
                    + "   JOIN MUNICIPIO MP ON BRR.idMunicipio = MP.id "
                    + "   WHERE BRR.nome LIKE '%" + valor[0].toString() + "%'"
                    + "      OR  MP.nome LIKE '%" + valor[0].toString() + "%'";
        }
        
        try {
            
            DefaultTableModel tabela = (DefaultTableModel)valor[1];
            
            preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
            this.resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                tabela.addRow(
                 new Object[]{
                     resultSet.getInt("id"),
                     resultSet.getString("nome"),
                     resultSet.getString("municipio"),
                     resultSet.getString("provincia")
                 }
                );
                
            }
            
            preparedStatement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoContactoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

