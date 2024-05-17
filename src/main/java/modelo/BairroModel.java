
package modelo;

/**
 *
 * @author ayrton.antonio    
 * id integer primary key autoincrement,
    nome         varchar(50) not null,
    provincia    varchar(50) not null,
    idMunicipio  integer not null
 */
public class BairroModel {
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private String nome;
    private String provincia;
    private String municipio;
    private int idMunicipio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
}
