package Responsavel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Usuario.Usuario;
import Grupo.Grupo;

public class Responsavel extends Usuario {
    public Responsavel(String nome, String email, String senha, Date dataCadastro, ArrayList<Grupo> grupos) {
        super(nome, email, senha, dataCadastro, grupos);
    }
    public static Responsavel criarResponsavel(ArrayList<Grupo> grp){

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do responsavel: ");
        String nome = in.nextLine();

        System.out.println("Insira o email do responsavel: ");
        String email = in.nextLine();

        System.out.println("Insira a senha do responsavel: ");
        String senha = in.nextLine();

        in.close();

        Date dataCadastro = new Date();
        ArrayList<Grupo> grupos = grp;

        Responsavel novo = new Responsavel(nome, email, senha, dataCadastro, grupos);
        return novo;
    }
    public ArrayList<Responsavel> removerResponsavel(ArrayList<Responsavel> responsaveis, Usuario responsavel){
        for(int i = 0;i<responsaveis.size();i++){
            if(responsaveis.get(i)==responsavel){
                responsaveis.remove(i);
                break;
            }
        }
        return responsaveis;
    }
}
