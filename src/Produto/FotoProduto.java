package Produto;

public class FotoProduto {
    private String contentType;
    private String nome, descricao;
    private int tamanho;

    public FotoProduto(String contentType, String nome, String descricao, int i) {
        this.contentType = contentType;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = i;
    }
    public String getContentType() {
        return contentType;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
}
