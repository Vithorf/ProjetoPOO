import Cidade.Cidade;
import Common.Endereco;
import Cozinha.Cozinha;
import Estado.Estado;
import FormaPagamento.FormaPagamento;
import Grupo.Grupo;
import Pedido.Pedido;
import Permissao.Permissao;
import Produto.Produto;
import Responsavel.Responsavel;
import Restaurante.Restaurante;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        Date now = new Date();
        Scanner in = new Scanner(System.in);

        System.out.println("\n------ APP DE RESTAURANTES ------\n");

        ArrayList<Permissao> permissoes = new ArrayList<Permissao>();
        permissoes.add(new Permissao(2,"Controle de restaurante/Gerenciar pedidos/Controle de produtos"));
        permissoes.add(new Permissao(1, "Fazer pedidos/Ver restaurantes"));
        
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();
        ArrayList<Permissao> perm = new ArrayList<Permissao>();

        perm.add(permissoes.get(0));
        grupos.add(new Grupo("Responsável",perm));
        perm.clear();

        perm.add(permissoes.get(1));
        grupos.add(new Grupo("Usuário", perm));
        perm.clear();

        ArrayList<Responsavel> responsaveis = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        ArrayList<Grupo> grp = new ArrayList<Grupo>();

        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        
        grp.add(grupos.get(0));
        responsaveis.add(new Responsavel("Joao", "joao@gmail.com", "Joao123", now, grp));
        grp.clear();

        ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();
        formaPagamentos.add(new FormaPagamento("Crédito"));
        formaPagamentos.add(new FormaPagamento("Débito"));
        formaPagamentos.add(new FormaPagamento("Pix"));

        ArrayList <Estado> estados = new ArrayList<Estado>();
        estados.add(new Estado("Bahia"));
        estados.add(new Estado("Pernambuco"));
 
        ArrayList <Cidade> cidades = new ArrayList<Cidade>();
        cidades.add(new Cidade("Petrolina",estados.get(1)));
        cidades.add(new Cidade("Juazeiro",estados.get(0)));

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
        ArrayList<Responsavel> resp = new ArrayList<>();

        resp.add(responsaveis.get(0));
        restaurantes.add(Restaurante.criarRestaurante(new Endereco("48900000", "Prédio", "75", "", "Centro", cidades.get(1)),resp , new Cozinha("Brasileira"), formaPagamentos));

        restaurantes.get(0).abrirRestaurante();

        String c = "y";
        while(c.equals("y")){
            restaurantes.get(0).cadastrarProduto(Produto.criaProduto());
            System.out.println("Cadastrar outro produto?(y/n) ");
            c = in.nextLine();
        }

        restaurantes.get(0).abrirRestaurante();

        restaurantes.get(0).exibirRestaurante();

        grp.add(grupos.get(1));
        usuarios.add(Usuario.criarUsuario(grp));

        usuarios.get(0).atualizarDados();

        pedidos.add(Pedido.criaPedido(restaurantes, usuarios.get(0), cidades));

        pedidos.get(0).setStatusConfirmado();

        pedidos.get(0).setStatusEntregue();




    }
}
