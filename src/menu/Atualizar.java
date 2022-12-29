package menu;

import java.util.Scanner;
import registration.Produto;
import storage.Dados;

public class Atualizar {

    public static void atualizacao(Dados dados, Scanner scanner) {
        boolean run = true;

        do {
            System.out.println("\n---------------\n| ATUALIZAÇÃO |\n---------------");
            System.out.print("1 - Alterar Preço de um Produto\n2 - Atualizar Nome de um Produto\n3 - Visualizar Lista de Produtos\n4 - Voltar\n\nDigite: ");
            switch (scanner.nextInt()) {
                case 1:
                    if (altValor(dados, scanner))
                        System.out.println("\nProduto inexistente, tente visualizar a lista.");
                    break;
                case 2:
                    if (altNome(dados, scanner))
                        System.out.println("\nProduto inexistente, tente visualizar a lista.");
                    break;   
                case 3:
                    Visualizar.ver(dados, scanner);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("\nInsira uma opção válida");
                    break;
            }
        } while (run);
    }

    public static boolean altNome(Dados dados, Scanner scanner){
        boolean ilegivel = true;

        scanner.nextLine();
        System.out.print("\nInsira o nome atual do produto: ");
        String nomeProduto = scanner.nextLine();

        for (Produto p : dados.getProdutos()) {
            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                ilegivel = false;

                System.out.println("\nProduto encontrado.");
                System.out.print("\nInsira o novo nome do produto: ");
                String newNomeProduto = dados.setFirstUpperCase(scanner.nextLine());
                
                p.setNomeProduto(newNomeProduto);
                System.out.println("\nNome alterado com sucesso.");
            }
        }
        return ilegivel;
    }

    public static boolean altValor(Dados dados, Scanner scanner){
        boolean ilegivel = true;

        scanner.nextLine();
        System.out.print("\nInsira o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        for (Produto p : dados.getProdutos()) {
            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                ilegivel = false;

                System.out.println("\nProduto encontrado.");

                System.out.print("\nInsira o novo valor para o produto: ");
                double newValorProduto = scanner.nextDouble();

                p.setValor(newValorProduto);

                System.out.println("\nValor alterado com sucesso.");
            }
        }
        return ilegivel;
    }
}