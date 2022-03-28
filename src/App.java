import FormaPagamento.FormaPagamento;
import Cozinha.Cozinha;
import Restaurante.Restaurante;
import Produto.Produto;
import Usuario.Usuario;
import Grupo.Grupo;
import Permissao.Permissao;
import Pedido.ItemPedido;
import Pedido.Pedido;
import Common.Endereco;
import Cidade.Cidade;
import Estado.Estado;
import Produto.FotoProduto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        Scanner entrada = new Scanner(System.in);
        Date now = new Date();

        System.out.println("\n------ APP DE RESTAURANTES ------\n");

        ArrayList<Permissao> permissoes = new ArrayList<Permissao>();
        permissoes.add(new Permissao("Média","Controle de restaurante/Gerenciar pedidos/Controle de produtos"));
        permissoes.add(new Permissao("Baixa", "Fazer pedidos/Ver restaurantes"));
        
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();
        ArrayList<Permissao> perm = new ArrayList<Permissao>();

        perm.add(permissoes.get(0));
        grupos.add(new Grupo("Responsável",perm));
        perm.clear();

        perm.add(permissoes.get(1));
        grupos.add(new Grupo("Usuário", perm));
        perm.clear();


        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Grupo> grp = new ArrayList<Grupo>();
        
        grp.add(grupos.get(0));
        usuarios.add(new Usuario("Joao", "joao@gmail.com", "Joao123", now, grp));
        grp.clear();

        grp.add(grupos.get(1));
        usuarios.add(new Usuario("jose", "email", "senha", now, grp));

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
        restaurantes.add(new Restaurante("default",7 ,true,false,now,now, 
        new Endereco("123456789", "Casa", "10", "rua c", "Joao 123", cidades.get(1)), usuarios, 
        new Cozinha("Mista"), formaPagamentos ));
        
        restaurantes.get(0).cadastrarProdutos(new Produto("default", "descricao", 50, true, new FotoProduto("contentType", "nome", "descricao", 3)));
        Restaurante res = restaurantes.get(0);
        System.out.println("Nome do restaurante: "+res.getNome()+"\nEstado: "+res.getEndereco().getCidade().getEstado().getNome()+"\nCidade: "+res.getEndereco().getCidade().getNome());

        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();
        itens.add(new ItemPedido(1, 7, 7, "observacao", restaurantes.get(0).getProdutos().get(0)) );
        
        pedido.add(new Pedido("código",
        50,6,now,itens,
        new Endereco("cep", "logradouro", "numero", "complemento", "bairro", cidades.get(1)),
        usuarios.get(1), restaurantes.get(0), formaPagamentos.get(0) ));
        
        
       /* System.out.printf("Informe os dados do seu novo restaurante:\n");
        
        
        String nomeRestaurante = entrada.nextLine();

        System.out.printf("Valor do frete em R$:\n");
        BigDecimal freteRestaurante = entrada.nextBigDecimal();

        System.out.printf("O restaurante está ativo? [y/n]\n");
        boolean ativoRestaurante = entrada.nextLine() == "y" ? true : false;

        System.out.printf("Informe quem é o primeiro responsável pelo restaurante\n(demais responsáveis poderão ser adicionados posteriormente)\n");
        
        Usuario responsavel = new Usuario();

        System.out.printf("Nome:\n");
        String nomeResp = entrada.nextLine();
        responsavel.setNome(nomeResp);

        System.out.printf("E-mail:\n");
        String emailResp = entrada.nextLine();
        responsavel.setEmail(emailResp);

        System.out.printf("Senha:\n");
        String senhaResp = entrada.nextLine();
        responsavel.setSenha(senhaResp);
        
        // definir grupo e permiissão do grupo

        System.out.printf("Informe o endereço do restaurante:\n");
        

        Endereco end = new Endereco();
        
        Cozinha cozinha = new Cozinha();
        System.out.printf("Nome da Cozinha:\n");
        String nomeCozinha = entrada.nextLine();
        cozinha.setNome(nomeCozinha);

        Restaurante res = new Restaurante(nomeRestaurante,freteRestaurante,ativoRestaurante,false,now,now,end, responsavel,cozinha);*/
        
        
        // CRIA RESTAURANTE
        
    }
}
