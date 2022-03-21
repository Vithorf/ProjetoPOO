package Restaurante;

import Common.Endereco;
import Cidade.Cidade;
import Estado.Estado;
import Produto.Produto;
import Usuario.Usuario;
import Cozinha.Cozinha;
import FormaPagamento.FormaPagamento;

import java.math.BigDecimal;
import java.util.Scanner;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;



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
    private int quantidadeProdutos;
    
    public Restaurante() {
                
                Scanner entrada = new Scanner(System.in);
                Date now = new Date();
                System.out.printf("Informe os dados do seu novo restaurante:\n");
                
                System.out.printf("Nome do restaurante:\n");
                String nomeRestaurante = entrada.nextLine();

                System.out.printf("Valor do frete em R$:\n");
                BigDecimal freteRestaurante = entrada.nextBigDecimal();

                System.out.printf("O restaurante está ativo? [y/n]\n");
                String ativoRestaurante = entrada.nextLine();

                System.out.printf("Informe quem é o primeiro responsável pelo restaurante\n(demais responsáveis poderão ser adicionados posteriormente)\n");
                
                Usuario responsavel = new Usuario();

                System.out.printf("Nome:\n");
                String nomeResp = entrada.nextLine();
                responsavel.setNome(nomeResp);

                System.out.printf("E-mail:\n");
                String emailResp = entrada.nextLine();
                responsavel.setEmail(emailResp);

                System.out.printf("Senha:\n");
                String senhaResp = entrada.nextLine();
                responsavel.setSenha(senhaResp);

                responsavel.setDataCadastro(now);
                
                // definir grupo e permiissão do grupo

                System.out.printf("Informe o endereço do restaurante:\n");
                
                Endereco end = new Endereco();
                
                Cozinha cozinha = new Cozinha();
                System.out.printf("Nome da Cozinha:\n");
                String nomeCozinha = entrada.nextLine();
                cozinha.setNome(nomeCozinha);

                this.nome = nomeRestaurante;
                this.taxaFrete = freteRestaurante;
                this.ativo = ativoRestaurante=="yes"?true:false;
                this.aberto = false;
                this.dataCadastro = now;
                this.dataAtualizacao = now;
                this.endereco = end;
                this.responsaveis.add(responsavel);
                this.cozinha = cozinha;
                this.quantidadeProdutos = 0;
    }

    public void cadastrarProdutos(){}

    public void adicionarFormaPag(){}

    public void abrirRestaurante(){
        if(this.quantidadeProdutos==0){
            System.out.printf("Não há produtos registrados\n");
        }
        else this.aberto = true;        
    }

    public void fecharRestaurante(){
        this.aberto = false;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
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


