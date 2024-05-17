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
import modelo.MunicipioModel;
import modelo.TipoContactoModel;


/**
 *
 * @author ayrton.antonio
 */
public class MunicipioDAO  extends DAOHelper implements IDataAcessObjects
{
    
        @Override
    public void Guardar(Object valor) {
        MunicipioModel model = (MunicipioModel)valor;    
        
        try 
        {
            
            if(model.getId() == 0)
            {
                this.sqlQuary = "INSERT INTO Municipio(nome,provincia) VALUES (?,?)";
                
                this.preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
                this.preparedStatement.setString(1, model.getNome());
                this.preparedStatement.setString(2, model.getProvinvia());
            }else{
                sqlQuary = "UPDATE Municipio " +
                           " SET nome = ? ,provincia = ? " +
                           " WHERE id = ? ";                
                
                this.preparedStatement = ConexaoBaseDados.abrirConexao().prepareStatement(sqlQuary);
                this.preparedStatement.setString(1, model.getNome());
                this.preparedStatement.setString(2, model.getProvinvia());
                this.preparedStatement.setInt(3, model.getId());
            }
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
        sqlQuary = "DELETE FROM Municipio WHERE id = ?";
        
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
        String sqlQuery = "SELECT id, nome FROM Municipio";
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
            sqlQuary = "SELECT * FROM Municipio";
        }else{
            sqlQuary = "SELECT * FROM Municipio " +
                    " WHERE nome LIKE '%" + valor[0].toString() + "%'" + 
                    " OR  provincia LIKE '%" + valor[0].toString() + "%'";
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

