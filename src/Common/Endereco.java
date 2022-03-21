package Common;
import Cidade.Cidade;
import Estado.Estado;

import java.math.BigDecimal;
import java.util.Scanner;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;

public class Endereco {
    private String cep, logradouro, numero, complemento, bairro;
    private Cidade cidade;
    
    public Endereco() {

        Scanner entrada = new Scanner(System.in);

        Cidade cidade = new Cidade();
        Estado estado = new Estado();

        System.out.printf("Estado:\n");
        String stateName = entrada.nextLine();
        estado.setNome(stateName);

        System.out.printf("Cidade:\n");
        String cityName = entrada.nextLine();

        cidade.setNome(cityName);
        cidade.setEstado(estado);

        System.out.printf("CEP:\n");
        String cep = entrada.nextLine();

        System.out.printf("Logradouro:\n");
        String logradouro = entrada.nextLine();

        System.out.printf("Número:\n");
        String numero = entrada.nextLine();

        System.out.printf("Complemento:\n");
        String complemento = entrada.nextLine();

        System.out.printf("Bairro:\n");
        String bairro = entrada.nextLine();

        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public String getCep() {
        return cep;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

}