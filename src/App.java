import FormaPagamento.FormaPagamento;
import Cozinha.Cozinha;
import Restaurante.Restaurante;
import Produto.Produto;
import Responsavel.Responsavel;
import Usuario.Usuario;
import Grupo.Grupo;
import Permissao.Permissao;
import Pedido.Pedido;
import Common.Endereco;
import Cidade.Cidade;
import Estado.Estado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {


        Date now = new Date();

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
        
        grp.add(grupos.get(0));
        responsaveis.add(new Responsavel("Joao", "joao@gmail.com", "Joao123", now, grp));
        grp.clear();

        responsaveis.get(0).atualizarDados();

        grp.add(grupos.get(1));
        responsaveis.add(new Responsavel("jose", "email", "senha", now, grp));

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

        ArrayList <Restaurante> restaurantes = new ArrayList<Restaurante>();
        restaurantes.add(new Restaurante("default", new BigDecimal("7"), true, false, now, now, 
        new Endereco("123456789", "Casa", "10", "rua c", "Joao 123", cidades.get(1)), responsaveis, 
        new Cozinha("Mista"), formaPagamentos));
        
        restaurantes.get(0).cadastrarProduto(Produto.criaProduto());
        Restaurante res = restaurantes.get(0);
        restaurantes.get(0).abrirRestaurante();


        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    
        ArrayList<Responsavel> r = new ArrayList<Responsavel>();
        r.add(responsaveis.get(0));

        restaurantes.add(Restaurante.criarRestaurante(res.getEndereco(), r, new Cozinha("nome"),formaPagamentos));
        restaurantes.get(1).getProdutos().add(Produto.criaProduto());
        restaurantes.get(1).abrirRestaurante();

        restaurantes.add(new Restaurante("default2",new BigDecimal("7") ,true,false,now,now, 
        new Endereco("123456789", "Casa", "10", "rua c", "Joao 123", cidades.get(1)), responsaveis, 
        new Cozinha("Mista"), formaPagamentos ));

        restaurantes.get(2).cadastrarProduto(Produto.criaProduto());
        restaurantes.get(2).abrirRestaurante();
        

        pedidos.add(Pedido.criaPedido(restaurantes, usuarios.get(0), cidades));
    }
}
