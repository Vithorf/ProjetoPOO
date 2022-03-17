package Pedido;
import Common.Endereco;
import Usuario.Usuario;
import Restaurante.Restaurante;
import FormaPagamento.FormaPagamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private String codigo;
    private BigDecimal subtotal, taxaFrete;
    private Date dataCriacao, dataConfirmacao, dataEntrega, dataCancelamento; 
    private ArrayList <ItemPedido> itens = new ArrayList<ItemPedido>();
    private StatusPedido status;
    private Endereco enderecoEntrega;
    private Usuario cliente;
    private Restaurante restaurante;
    private FormaPagamento formaPagamento;
    

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    public Usuario getCliente() {
        return cliente;
    }
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public ArrayList <ItemPedido> getItens() {
        return itens;
    }
    public void setItens(ArrayList <ItemPedido> itens) {
        this.itens = itens;
    }
    public Date getDataCancelamento() {
        return dataCancelamento;
    }
    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }
    public Date getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public Date getDataConfirmacao() {
        return dataConfirmacao;
    }
    public void setDataConfirmacao(Date dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }
    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
