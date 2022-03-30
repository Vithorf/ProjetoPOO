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
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.observacao = observacao;
        this.produto = produto;
    }
}
