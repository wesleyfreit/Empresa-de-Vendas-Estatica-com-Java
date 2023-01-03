package menu.functions;

import java.util.List;

import app.Empresa;
import registration.Produto;

public class Busca {
    public static int buscaString() {

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o nome do produto que deseja buscar: ");
        String nomeProduto = Empresa.scanner.nextLine();

        List<Produto> resultadoBusca = Empresa.dados.busca(nomeProduto);
        
        if(resultadoBusca.size() > 0){
            System.out.println("\nProdutos Encontrados\n");

            System.out.println("-------------------------------------------------");
            System.out.println("| Id -> Produto -> Público -> Preço -> Quantidade");
            System.out.println("-------------------------------------------------");

            for(Produto p : resultadoBusca){
                System.out.print("| " + p.getId());
                System.out.print(" -> " + p.getNomeProduto());
                System.out.print(" -> " + p.getPublico());
                System.out.print(" -> " + p.getValor());
                System.out.println(" -> " + p.getQuantidade());
            }
            System.out.print("\nDigite o id correspondente da lista: ");
            return Empresa.scanner.nextInt();
        }
        return -1;
    }
}
