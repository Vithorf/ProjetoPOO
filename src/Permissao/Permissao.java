package Permissao;

public class Permissao {
    private int nivel;
    private String descricao;

    public Permissao(int nivel, String descricao) {
        this.nivel = nivel;
        this.descricao = descricao;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
