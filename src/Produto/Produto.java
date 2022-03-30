package Produto;

import java.math.BigDecimal;

public class Produto {
    private String nome, descricao;
    private BigDecimal preco;
    private boolean ativo;
    private FotoProduto foto;
    
    public Produto(String nome, String descricao, BigDecimal preco, boolean ativo, FotoProduto foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
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
