package Restaurante;

import Common.Endereco;
import Cidade.Cidade;
import Estado.Estado;
import Produto.Produto;
import Usuario.Usuario;
import Cozinha.Cozinha;
import FormaPagamento.FormaPagamento;

import java.util.Scanner;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;



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
    


    public Restaurante(String nome, BigDecimal taxaFrete, boolean ativo, boolean aberto, Date dataCadastro,
            Date dataAtualizacao, Endereco endereco, ArrayList<Usuario> responsaveis, Cozinha cozinha,
            ArrayList<FormaPagamento> formasPagamento) {
                
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.endereco = endereco;
        this.responsaveis = responsaveis;
        this.cozinha = cozinha;
        this.formasPagamento = formasPagamento;
        
    }

    public void cadastrarProdutos(Produto produto){
        this.getProdutos().add(produto);
    }

    public void adicionarFormaPag(){}

    public void abrirRestaurante(){
        if(this.produtos.size()==0){
            System.out.printf("Não há produtos registrados\n");
        }
        else this.aberto = true;        
    }

    public void fecharRestaurante(){
        this.aberto = false;
    }

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


