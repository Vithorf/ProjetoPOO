package Produto;

import java.math.BigDecimal;

public class Produto {
    private String nome, descricao;
    private float preco;
    private boolean ativo;
    private FotoProduto foto;
    
    public Produto(String nome, String descricao, float i, boolean ativo, FotoProduto foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = i;
        this.ativo = ativo;
        this.foto = foto;
    }
    public String getNome() {
        return nome;
    }
    public FotoProduto getFoto() {
        return foto;
    }
    public void setFoto(FotoProduto foto) {
        this.foto = foto;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
