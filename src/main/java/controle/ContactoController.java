package controle;

import dao.ContactoDAO;
import dao.TipoContactoDAO;
import dao.MunicipioDAO;
import dao.BairroDAO;
import interfaces.IControle;
import modelo.ContactoModel;

public class ContactoController implements IControle
{
    
    ContactoDAO dataAcess = new ContactoDAO();
    TipoContactoDAO dataAcessTipoContacto = new TipoContactoDAO();
    MunicipioDAO dataAcessMunicipio = new MunicipioDAO();
    BairroDAO dataAcessBairro = new BairroDAO();

    @Override
    public void Guardar(Object... valor) {
        ContactoModel model = new ContactoModel();
        if("".equals(valor[0])){
            model.setId(0);
        }else{
            model.setId(Integer.parseInt(valor[0].toString()));        
        } 
        //nome,telefone,whatsapp,email,idTipoContacto,idMunicipio,idBairro
        model.setNome(valor[1].toString());        
        model.setTelefone(valor[2].toString());
        model.setWhatsapp(valor[3].toString());
        model.setEmail(valor[4].toString());
        model.setIdTipoContacto(Integer.parseInt(valor[5].toString()));
        model.setIdMunicipio(Integer.parseInt(valor[6].toString()));
        model.setIdBairro(Integer.parseInt(valor[6].toString()));


        dataAcess.Guardar(model);
        
    }

    @Override
    public void Excluir(int id) {
        dataAcess.Excluir(id);
    }

    @Override
    public void CarregarComboBox(Object cbo) 
    {
        
        dataAcess.CarregarComboBox(cbo);
        
    }
    
    public void CarregarTipoContactoComboBox(Object cbo) 
    {
        dataAcessTipoContacto.CarregarComboBox(cbo);
    }
    
    
    public void CarregarMunicipiosComboBox(Object cbo) 
    {
        dataAcessMunicipio.CarregarComboBox(cbo);
    }    
    
    public void CarregarBairrosComboBox(Object cbo,int idMunicipio) 
    {
        dataAcessBairro.CarregarComboBox(cbo,idMunicipio);
    }

    @Override
    public void Consultar(Object... valor) {
        dataAcess.Consultar(valor);
    }
    
}
