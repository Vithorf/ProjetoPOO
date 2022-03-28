package Usuario;
import java.util.ArrayList;
import java.util.Date;
import Grupo.Grupo;

public class Usuario {
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
    public String getNome() {
        return nome;
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
    public void setNome(String nome) {
        this.nome = nome;
    }
}
