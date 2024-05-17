package modelo;

/**
 *
 * @author ayrton.antonio
 */
public class ComboBoxItem {
    private int id;
    private String descricao;
    
    public ComboBoxItem(int id, String nome) {
        this.id = id;
        this.descricao = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString() {
        return descricao; 
    }
}
