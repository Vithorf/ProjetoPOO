package Pedido;

import Common.Endereco;
import Usuario.Usuario;
import Restaurante.Restaurante;
import FormaPagamento.FormaPagamento;
import Pedido.StatusPedido;
import Produto.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Scanner;

import Cidade.Cidade;


public class Pedido {

    private String codigo;
    private BigDecimal subtotal, taxaFrete, valorTotal;
    private Date dataCriacao, dataConfirmacao, dataEntrega, dataCancelamento; 
    private ArrayList <ItemPedido> itens = new ArrayList<ItemPedido>();
    private StatusPedido.status status;
    private Endereco enderecoEntrega;
    private Usuario cliente;
    private Restaurante restaurante;
    private FormaPagamento formaPagamento;
    

    public Pedido(String codigo, BigDecimal subtotal, BigDecimal taxaFrete, Date dataCriacao, ArrayList<ItemPedido> itens, Endereco enderecoEntrega, Usuario cliente, Restaurante restaurante,
            FormaPagamento formaPagamento) {
        this.codigo = codigo;
        this.subtotal = subtotal;
        this.taxaFrete = taxaFrete;
        this.dataCriacao = dataCriacao;
        this.itens = itens;
        this.status = StatusPedido.status.CRIADO;
        this.enderecoEntrega = enderecoEntrega;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.formaPagamento = formaPagamento;
        this.valorTotal = this.subtotal.add(this.taxaFrete);
    }

    public static Pedido criaPedido(ArrayList<Restaurante> restaurantes,Usuario cliente, ArrayList<Cidade> cidades){
        Scanner in = new Scanner(System.in);
        Date now = new Date();
        BigDecimal subtotal = new BigDecimal(0);
        

        System.out.println("Selecione o restaurante para pedir: ");
        for ( int i = 0; i<restaurantes.size(); i++){
            System.out.println("["+i+1+"] "+restaurantes.get(i).getNome()+"\n");
        }
        int op = in.nextInt();
        Restaurante restaurante = restaurantes.get(op-1);
        ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();
        String conti;

        do{
            System.out.println("Selecione o produto: ");
            for ( int i = 0; i<restaurante.getProdutos().size(); i++){
                System.out.println("["+i+1+"] "+restaurante.getProdutos().get(i).getNome()+"\n");
            }
            op = in.nextInt();
            Produto produto = restaurante.getProdutos().get(op-1);
            ItemPedido item = new ItemPedido(0, produto.getPreco(), new BigDecimal(0), "observacao", produto);
            System.out.println("Selecione a quantidade: ");
            op = in.nextInt();
            item.setQuantidade(op);
            item.setPrecoTotal(item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())));
            System.out.println("Obsvervações: ");
            String obs = in.nextLine();
            item.setObservacao(obs);
            itens.add(item);
            System.out.println("Adicionar mais produtos?(y/n) ");
            conti = in.nextLine();
        }while(conti == "y");

        System.out.println("Adicionar forma de pagamento: ");
        for ( int i = 0; i<restaurante.getFormasPagamento().size(); i++){
            System.out.println("["+i+1+"] "+restaurante.getFormasPagamento().get(i)+"\n");
        }
        op = in.nextInt();
        FormaPagamento formaPagamento = restaurante.getFormasPagamento().get(op-1);

        System.out.println("Adicionar adicionar endereço de entrega: ");
        System.out.println("\nInsira o CEP: ");
        String cep = in.nextLine();
        System.out.println("\nInsira o logradouro: ");
        String logradouro = in.nextLine();
        System.out.println("\nInsira o número: ");
        String numero = in.nextLine();
        System.out.println("\nInsira o complemento: ");
        String complemento = in.nextLine();
        System.out.println("\nInsira o bairro: ");
        String bairro = in.nextLine();
        System.out.println("\nInsira o a cidade: ");
        for(int i = 0; i<cidades.size();i++){
            System.out.println("["+i+1+"] "+cidades.get(i).getNome()+" - "+cidades.get(i).getEstado().getNome()+"\n");
        }
        op = in.nextInt();
        Cidade cidade = cidades.get(op-1);
        Endereco enderecoEntrega = new Endereco(cep, logradouro, numero, complemento, bairro, cidade);

        String codigo = "";
        codigo += restaurante.getNome().substring(0, 3)+"#";
        for ( int i = 0; i<itens.size(); i++){
            codigo+=itens.get(i).getProduto().getNome().substring(0, 3)+"-";
            subtotal.add(itens.get(i).getPrecoTotal());
        }
        codigo+=now.toString();

        Date dataCriacao = now;
        BigDecimal taxaFrete = restaurante.getTaxaFrete();
        
        Pedido ped = new Pedido(codigo, subtotal, taxaFrete, dataCriacao, itens, enderecoEntrega, cliente, restaurante, formaPagamento);
        return ped;
    }

    public StatusPedido.status getStatus() {
        return status;
    }

    public void setStatusConfirmado() {
        this.status = status.CONFIRMADO;
    }

    public void setStatusEntregue() {
        this.status = status.ENTREGE;
    }

    public void setStatusCancelado() {
        this.status = status.CANCELADO;
    }

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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
