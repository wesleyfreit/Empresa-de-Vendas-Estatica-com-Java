package menu;

import java.util.Scanner;
import registration.Produto;
import storage.Dados;

public class Fornecer {

    public static void fornecimento(Dados dados, Scanner scanner) {
        String nomeProduto;
        int quantidade = 0;

        scanner.nextLine();
        System.out.print("\nInsira o nome do produto que deseja buscar: ");
        nomeProduto = scanner.nextLine();

        boolean verification = true;

        for (Produto p : dados.getProdutos()) {

            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                
                verification = false;

                System.out.println("\nProduto Encontrado.");
                System.out.print("\nInsira a nova quantidade a repor: ");
                quantidade = scanner.nextInt();

                p.setQuantidade(quantidade);
                
                System.out.println("\nReposição concluída.");
            }
        }
        if (verification) {
            System.out.println("\nProduto Inexistente.");
        }
    }
}