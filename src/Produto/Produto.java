package Produto;

import java.math.BigDecimal;
import java.util.Scanner;

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

    public static Produto criaProduto(){
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do produto: ");
        String nome = in.nextLine();
        System.out.println("Insira a descrição do produto: ");
        String desc = in.nextLine();
        System.out.println("Insira o preço do produto: ");
        String preco = in.nextLine();
        FotoProduto foto = new FotoProduto("jpg", "nome.jpg", "descricao", 3);

        in.close();

        Produto produto = new Produto(nome, desc, new BigDecimal(preco), true, foto);
        System.out.println("Produto cadastrado com sucesso!\n\n");
        return produto;
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
