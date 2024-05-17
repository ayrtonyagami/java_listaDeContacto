/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.MunicipioDAO;
import interfaces.IControle;
import modelo.MunicipioModel;

/**
 *
 * @author ayrton.antonio
 */
public class MunicipioController implements IControle
{
    
    MunicipioDAO dataAcess = new MunicipioDAO();

    @Override
    public void Guardar(Object... valor) {
        MunicipioModel model = new MunicipioModel();
        if("".equals(valor[0])){
            model.setId(0);
        }else{
            model.setId(Integer.parseInt(valor[0].toString()));        
        }        
        model.setNome(valor[1].toString());        
        model.setProvinvia(valor[2].toString());


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

    @Override
    public void Consultar(Object... valor) {
        dataAcess.Consultar(valor);
    }
    
}
