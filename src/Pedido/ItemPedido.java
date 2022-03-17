package Pedido;

import java.math.BigDecimal;

import Produto.Produto;

public class ItemPedido {
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;
    private Produto produto;
}
