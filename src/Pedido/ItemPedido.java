package Pedido;

import java.math.BigDecimal;

import Produto.Produto;

public class ItemPedido {
    private int quantidade;
    private BigDecimal precoUnitario, precoTotal; 
    private String observacao;
    private Produto produto;

    public ItemPedido(int quantidade, BigDecimal precoUnitario, BigDecimal precoTotal, String observacao,
            Produto produto) {
        this.setQuantidade(quantidade);
        this.setPrecoUnitario(precoUnitario);
        this.setPrecoTotal(precoTotal);
        this.setObservacao(observacao);
        this.setProduto(produto);
    }

    public void exibirItemPedido(){
        System.out.println("\nProduto: "+
        this.getProduto().getNome()+" -------- R$"+this.getPrecoUnitario().toString()+" -------- "+this.getQuantidade()+" Und.\n"+
        "Observações: "+this.getObservacao()+"\n"+"Total: R$"+this.getPrecoTotal()
        
        );
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
