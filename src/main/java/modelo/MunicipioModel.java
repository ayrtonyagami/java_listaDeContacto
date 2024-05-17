package modelo;


/**
 *
 * @author ayrton.antonio
 */
public class MunicipioModel {
//    id integer primary key autoincrement,
//    nome varchar(50) not null,
//    provincia varchar(50) not null
    
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvinvia() {
        return provinvia;
    }

    public void setProvinvia(String provinvia) {
        this.provinvia = provinvia;
    }
    private String provinvia;
}
