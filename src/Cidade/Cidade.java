package Cidade;
import java.util.ArrayList;
import java.util.Scanner;

import Estado.Estado;

public class Cidade {
    private String nome;
    private Estado estado;
    
    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public static Cidade criaCidade(ArrayList<Cidade> c, ArrayList<Estado> e){
        Scanner in = new Scanner(System.in);

        System.out.println("Cadastro de cidade");
        System.out.println("\nInsira o nome da cidade: ");
        String nome = in.nextLine();
        System.out.println("A cidade "+nome+" pertence a algum estado abaixo?:(y/n)\n");
        for(int i = 0;i<e.size();i++){
            System.out.println("["+i+1+"] "+e.get(i).getNome()+"\n");
        }
        Estado estado;
        String op = in.nextLine();
        if(op=="y"){
            System.out.println("Insira o numero do estado para cadastrar a cidade"+nome+":\n");
            int op1 = in.nextInt();
            estado = e.get(op1);
        }
        else{
            System.out.println("Insira o nome do estado da cidade "+nome+":\n");
            op = in.nextLine();
            estado = new Estado(op);
        }
        in.close();
        Cidade cidade = new Cidade(nome, estado);
        return cidade;
    }

    public String getNome() {
        return nome;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
