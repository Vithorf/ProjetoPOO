package Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Grupo.Grupo;
import Interfaces.CRUDUser;

public class Usuario implements CRUDUser {
    private String nome, email, senha;
    private Date dataCadastro;
    private ArrayList <Grupo> grupos = new ArrayList<Grupo>();

    public Usuario(String nome, String email, String senha, Date dataCadastro, ArrayList<Grupo> grupos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.grupos = grupos;
    }

    public Usuario(String nome, String email, String senha, Date dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.grupos = null;
    }

    public static Usuario criarUsuario(ArrayList<Grupo> grp){

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do usuário: ");
        String nome = in.nextLine();

        System.out.println("Insira o email do usuário: ");
        String email = in.nextLine();

        System.out.println("Insira a senha do usuário: ");
        String senha = in.nextLine();

        in.close();

        Date dataCadastro = new Date();
        ArrayList<Grupo> grupos = grp;

        Usuario novo = new Usuario(nome, email, senha, dataCadastro, grupos);
        return novo;
    }

    public void exibirDados(){
        System.out.println("\nNome do usuário: "+this.getNome()+"\nEmail: "+this.getEmail()+"\nData de cadastro: "+this.getDataCadastro().toString()+"Grupos: ");
        for (int i = 0;i<this.getGrupos().size();i++){
            System.out.println(this.getGrupos().get(i)+"\n");
        }

    }

    public void atualizarDados(){

        String a;
        Scanner in = new Scanner(System.in);
        this.exibirDados();

        System.out.println("Atualizar o nome? (y/n)");
        a = in.nextLine();
        if(a=="y"){
            System.out.println("Insira o novo nome: ");
            a = in.nextLine();
            this.setNome(a);
        }

        System.out.println("Atualizar o email? (y/n)");
        a = in.nextLine();
        if(a=="y"){
            System.out.println("Insira o novo email: ");
            a = in.nextLine();
            this.setEmail(a);
        }

        System.out.println("Atualizar a senha? (y/n)");
        a = in.nextLine();
        if(a=="y"){
            do{
            System.out.println("Insira a antiga senha: ");
            a = in.nextLine();
            if(a != this.getSenha()){
                System.out.println("A senha está incorreta\nTentar novamente?(y/n)");
                a = in.nextLine();
                if(a=="n") break;}
            }while(a!=this.getSenha());
            if(a!="n"){
                System.out.println("Insira a nova senha: ");
                a = in.nextLine();
                this.setSenha(senha);
                    System.out.println("Usuário atualizado com sucesso!");
            }
        }
        else{
            do{
                System.out.println("Insira a senha: ");
                a = in.nextLine();
                if(a != this.getSenha()){
                    System.out.println("A senha está incorreta\nTentar novamente?(y/n)");
                    a = in.nextLine();
                    if(a=="n") break;}
                }while(a!=this.getSenha());
                if(a==this.getSenha()){ 
                    System.out.println("Usuário atualizado com sucesso!");
                }
        }
        System.out.println("Nenhuma atualização foi feita!");
        in.close();
    }

    public ArrayList<Usuario> removerUsuario(ArrayList<Usuario> users,Usuario user){
        for(int i = 0;i<users.size();i++){
            if(users.get(i)==user){
                users.remove(i);
                break;
            }
        }
        return users;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList <Grupo> getGrupos() {
        return grupos;
    }
    public void setGrupos(ArrayList <Grupo> grupos) {
        this.grupos = grupos;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
