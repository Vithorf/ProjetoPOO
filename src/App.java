import FormaPagamento.FormaPagamento;
import Cozinha.Cozinha;
import Restaurante.Restaurante;
import Produto.Produto;
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
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n------ APP DE RESTAURANTES ------\n");
        
        Scanner entrada = new Scanner(System.in);
        Date now = new Date();
        
        // CRIA RESTAURANTE
        System.out.printf("Informe os dados do seu novo restaurante:\n");
        Restaurante res = new Restaurante();
        
        System.out.printf("Nome:\n");
        String nomeRestaurante = entrada.nextLine();
        res.setNome(nomeRestaurante);

        System.out.printf("Valor do frete em R$:\n");
        BigDecimal freteRestaurante = entrada.nextBigDecimal();
        res.setTaxaFrete(freteRestaurante);

        System.out.printf("O restaurante está ativo? [y/n]\n");
        String ativoRestaurante = entrada.nextLine();
        if(ativoRestaurante == "y")
            res.setAtivo(true);
        else
            res.setAtivo(false);

        System.out.printf("O restaurante está aberto? [y/n]\n");
        String abertoRestaurante = entrada.nextLine();
        if(abertoRestaurante == "y")
            res.setAberto(true);
        else
            res.setAberto(false);

        res.setDataCadastro(now);
        res.setDataAtualizacao(now);

        System.out.printf("Informe quem é o primeiro responsável pelo restaurante\n(demais responsáveis poderão ser adicionados posteriormente)\n");
        
        Usuario responsavel = new Usuario();
        System.out.printf("Nome:\n");
        String nomeResp = entrada.nextLine();
        responsavel.setNome(nomeResp);
        System.out.printf("E-mail:\n");
        String emailResp = entrada.nextLine();
        responsavel.setNome(emailResp);
        System.out.printf("Senha:\n");
        String senhaResp = entrada.nextLine();
        responsavel.setNome(senhaResp);
        responsavel.setDataCadastro(now);
        
        // definir grupo e permiissão do grupo

        ArrayList<Usuario> usuario = new ArrayList<>();
        usuario.add(responsavel);
        res.setResponsaveis(usuario);

        // definir endereço
        // definir lista de produtos
        // definir cozinha
        // definir formasPagamento
    }
}
