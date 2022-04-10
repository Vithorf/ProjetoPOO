package Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Usuario.Usuario;

public class Cliente extends Usuario {
    public Cliente(String nome, String email, String senha, Date dataCadastro) {
        super(nome, email, senha, dataCadastro);
    }
    public static Cliente criarCliente(){

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do cliente: ");
        String nome = in.nextLine();

        System.out.println("Insira o email do cliente: ");
        String email = in.nextLine();

        System.out.println("Insira a senha do cliente: ");
        String senha = in.nextLine();

        in.close();

        Date dataCadastro = new Date();

        Cliente novo = new Cliente(nome, email, senha, dataCadastro);
        return novo;
    }
    public ArrayList<Cliente> removerCliente(ArrayList<Cliente> clientes, Cliente cliente){
        for(int i = 0;i<clientes.size();i++){
            if(clientes.get(i)==cliente){
                clientes.remove(i);
                break;
            }
        }
        return clientes;
    }
}