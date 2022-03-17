package Restaurante;
import java.math.BigDecimal;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;
import Common.Endereco;
import Produto.Produto;
import Usuario.Usuario;
import Cozinha.Cozinha;
import FormaPagamento.FormaPagamento;

public class Restaurante {
    private String nome;
    private BigDecimal taxaFrete;
    private boolean ativo, aberto;
    private Date dataCadastro, dataAtualizacao;
    private Endereco endereco; 
    private ArrayList<Usuario>responsaveis = new ArrayList<Usuario>();
    private Cozinha cozinha;
    private ArrayList<FormaPagamento>formasPagamento = new ArrayList<FormaPagamento>();
    private ArrayList<Produto>produtos = new ArrayList<Produto>();
    
    public String getNome() {
        return nome;
    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    public ArrayList<FormaPagamento> getFormasPagamento() {
        return formasPagamento;
    }
    public void setFormasPagamento(ArrayList<FormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }
    public Cozinha getCozinha() {
        return cozinha;
    }
    public void setCozinha(Cozinha cozinha) {
        this.cozinha = cozinha;
    }
    public ArrayList<Usuario> getResponsaveis() {
        return responsaveis;
    }
    public void setResponsaveis(ArrayList<Usuario> responsaveis) {
        this.responsaveis = responsaveis;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public boolean isAberto() {
        return aberto;
    }
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }
    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}


