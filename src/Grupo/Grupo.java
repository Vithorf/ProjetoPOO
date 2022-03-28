package Grupo;
import Permissao.Permissao;
import java.util.ArrayList;

public class Grupo {
    private String nome;
    private ArrayList<Permissao>permissoes = new ArrayList<Permissao>();
    public Grupo(String nome, ArrayList<Permissao> permissoes) {
        this.nome = nome;
        this.permissoes = permissoes;
    }
    public String getNome() {
        return nome;
    }
    public ArrayList<Permissao> getPermissoes() {
        return permissoes;
    }
    public void setPermissoes(ArrayList<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
