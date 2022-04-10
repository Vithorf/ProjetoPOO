package Restaurante;

import Common.Endereco;
import Produto.Produto;
import Responsavel.Responsavel;
import Cozinha.Cozinha;
import FormaPagamento.FormaPagamento;
import Grupo.Grupo;
import Permissao.Permissao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;



public class Restaurante {
    private String nome;
    private BigDecimal taxaFrete;
    private boolean ativo, aberto;
    private Date dataCadastro, dataAtualizacao;
    private Endereco endereco; 
    private ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
    private Cozinha cozinha;
    private ArrayList<FormaPagamento>formasPagamento = new ArrayList<FormaPagamento>();
    private ArrayList<Produto>produtos = new ArrayList<Produto>();
    


    public Restaurante(String nome, BigDecimal taxaFrete, 
    boolean ativo, boolean aberto, Date dataCadastro,
            Date dataAtualizacao, Endereco endereco, 
            ArrayList<Responsavel> responsaveis, Cozinha cozinha,
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

    public static Restaurante criarRestaurante(Endereco e, ArrayList<Responsavel> u, Cozinha c, ArrayList<FormaPagamento> fp){

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do restaurante: ");
        String nome = in.nextLine();

        System.out.println("Insira a taxa de frete do restaurante: ");
        String tf = in.nextLine();
        BigDecimal taxaFrete = new BigDecimal(tf);

        in.close();
        
        Endereco endereco = e;
        Date dataCadastro = new Date();
        ArrayList<Responsavel> responsaveis = u;
        Cozinha cozinha = c;
        ArrayList<FormaPagamento> formasPagamento = fp;

        Restaurante novo = new Restaurante(nome, taxaFrete, true, false, dataCadastro, dataCadastro, endereco, responsaveis, cozinha, formasPagamento);
        return novo;
    }

    public void exibirRestaurante(){
        System.out.println("\n"+this.getNome()
            +"\nValor do frete (R$): "+this.getTaxaFrete()
            +"\nData de cadastro: "+this.getDataCadastro().toString()
            +"\nData de atualizacao: "+this.getDataAtualizacao().toString()

            +"\nEndereco: "
            +"\n"+this.getEndereco().getLogradouro()
            +", nº "+this.getEndereco().getNumero()
            +"\n"+this.getEndereco().getComplemento()
            +", "+this.getEndereco().getCep()
            +", "+this.getEndereco().getBairro()
            +"\n"+this.getEndereco().getCidade().getNome()
            +" - "+this.getEndereco().getCidade().getEstado().getNome()

        );

        System.out.println("\nResponsaveis: ");
        this.getResponsaveis().forEach((responsavel) -> System.out.println("\n- "+responsavel.getNome()));

        System.out.println("\nCozinha: "+this.getCozinha().getNome());

        System.out.println("\nFormas de pagamento: ");
        this.getFormasPagamento().forEach((formaPag) -> System.out.println("\n- "+formaPag.getDescricao()));
        
        if (this.isAtivo()) System.out.println("\n\nO restaurante esta ativo.");
        else System.out.println("\n\nO restaurante nao esta ativo.");

        if (this.isAberto()) System.out.println("\nO restaurante esta aberto nesse momento.");
        else System.out.println("\nO restaurante esta fechado.");
    }

    public Restaurante atualizarRestaurante() {
        System.out.println("\n--- DADOS ATUAIS ---\n");
        this.exibirRestaurante();
        int changeCounter = 0;
        Restaurante currentRestaurant = this;
        
        System.out.println("\n\nInsira a nova informacao quando for solicitada.\nSe não desejar atualizar o campo, apenas tecle ENTER.");
        String field;
        Scanner in = new Scanner(System.in);

        System.out.println("Nome do restaurante: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.setNome(field); 
            changeCounter++; 
        }

        System.out.println("Valor do frete em R$: ");
        field = in.nextLine();
        BigDecimal taxaFrete = new BigDecimal(field);
        if (field != "") { 
            currentRestaurant.setTaxaFrete(taxaFrete); 
            changeCounter++; 
        }

        System.out.println("Logradouro (ainda nao informar numero): ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().setLogradouro(field); 
            changeCounter++; 
        }

        System.out.println("Numero: ");
        field = in.nextLine();
        if (field != "") { currentRestaurant.getEndereco().setNumero(field); 
            changeCounter++; 
        }

        System.out.println("Complemento: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().setComplemento(field); 
            changeCounter++; 
        }

        System.out.println("CEP: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().setCep(field); 
            changeCounter++; 
        }

        System.out.println("Bairro: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().setBairro(field); 
            changeCounter++; 
        }

        System.out.println("Cidade: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().getCidade().setNome(field); 
            changeCounter++; 
        }

        System.out.println("Estado: ");
        field = in.nextLine();
        if (field != "") { 
            currentRestaurant.getEndereco().getCidade().getEstado().setNome(field); 
            changeCounter++; 
        }

        System.out.println("\n\nResponsaveis atuais: ");
        this.getResponsaveis().forEach((responsavel) -> System.out.println("\n- "+responsavel.getNome()));

        ArrayList<Responsavel> newResponsaveis = currentRestaurant.getResponsaveis();
        System.out.println("\n\nDeseja apagar os responsaveis atuais e inserir novos? (y/n)");
        field = in.nextLine();

        if (field == "y")
        newResponsaveis.clear();
        
        while (field == "y") {

            ArrayList<Permissao> permissoes = new ArrayList<>();
            Permissao media = new Permissao(2, "Controle de restaurante/Gerenciar pedidos/Controle de produtos");
            permissoes.add(media);

            ArrayList<Grupo> grp = new ArrayList<>();
            Grupo responsaveis = new Grupo("Responsavel", permissoes);
            grp.add(responsaveis);

            Responsavel newResponsavel = Responsavel.criarResponsavel(grp);
            newResponsaveis.add(newResponsavel);

            System.out.println("\nDeseja adicionar mais um responsavel? (y/n)");
            field = in.nextLine();    
        }
        currentRestaurant.setResponsaveis(newResponsaveis);

        System.out.println("Cozinha: ");
        field = in.nextLine();
        if (field != "") {
            Cozinha c = new Cozinha(field);
            currentRestaurant.setCozinha(c);
            changeCounter++; 
        }

        ArrayList<FormaPagamento> arrayfp = currentRestaurant.getFormasPagamento();
        System.out.println("\nDeseja apagar as formas de pagamento atuais e inserir novas? (y/n)");
        field = in.nextLine();    

        if (field == "y")
            arrayfp.clear();

        while (field == "y") {
            System.out.println("Forma de pagamento: ");
            field = in.nextLine();
            if (field != "") {
                FormaPagamento fp = new FormaPagamento(field);
                arrayfp.add(fp);
                changeCounter++; 
            }
            
            System.out.println("\nDeseja adicionar mais uma forma de pagamento? (y/n)");
            field = in.nextLine();    
        }
        currentRestaurant.setFormasPagamento(arrayfp);

        if (changeCounter > 0) {
            Date updatedAt = new Date();
            currentRestaurant.setDataAtualizacao(updatedAt);
        }

        in.close();
        return currentRestaurant;
    }

    public void removerRestaurante(ArrayList<Restaurante> listaRestaurantes) {
        listaRestaurantes.forEach(r -> {
            if (r == this) {
                listaRestaurantes.remove(r);
            }
        });
    }

    public void cadastrarProduto(Produto produto){
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
    public void setNome(String nome) {
        this.nome = nome;
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
    public ArrayList<Responsavel> getResponsaveis() {
        return responsaveis;
    }
    public void setResponsaveis(ArrayList<Responsavel> responsaveis) {
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
}
