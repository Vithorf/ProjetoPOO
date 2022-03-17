package Cidade;
import Estado.Estado;

public class Cidade {
    private String nome;
    private Estado estado;
    
    public String getNome() {
        return nome;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
