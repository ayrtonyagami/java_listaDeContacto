/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.BairroDAO;
import dao.MunicipioDAO;
import interfaces.IControle;
import modelo.BairroModel;
import modelo.MunicipioModel;

/**
 *
 * @author ayrton.antonio
 */
public class BairroController  implements IControle 
{
    BairroDAO dataAcess = new BairroDAO();
    MunicipioDAO dataAcessMunicipio = new MunicipioDAO();
    @Override
    public void Guardar(Object... valor) {
        BairroModel model = new BairroModel();
        if("".equals(valor[0])){
            model.setId(0);
        }else{
            model.setId(Integer.parseInt(valor[0].toString()));        
        }        
        model.setNome(valor[1].toString());        
        model.setIdMunicipio(Integer.parseInt(valor[2].toString()));

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
    
    public void CarregarMunicipiosComboBox(Object cbo) 
    {
        dataAcessMunicipio.CarregarComboBox(cbo);
    }   

    @Override
    public void Consultar(Object... valor) {
        dataAcess.Consultar(valor);
    }
    
    
}

