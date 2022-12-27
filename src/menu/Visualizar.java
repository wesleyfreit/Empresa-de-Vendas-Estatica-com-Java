package menu;

import java.util.Scanner;
import registration.Produto;
import storage.Dados;

public class Visualizar {

    public static void ver(Dados dados, Scanner scanner) {
        boolean run = true;

        do {
            System.out.println("\n------------------------\n| PRODUTOS CADASTRADOS |\n------------------------");
            System.out.print("1 - Ver Produtos Estocados\n2 - Ver Valores\n3 - Voltar\n\nDigite: ");
            switch (scanner.nextInt()) {
                case 1:
                    if (verQuantidade(dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 2:
                    if (verValor(dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("\nInsira uma opção válida");
                    break;
            }
        } while (run);
    }

    public static boolean verQuantidade(Dados dados) {
        boolean ilegivel = true;

        if (dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n------------------------------------");
            System.out.println("| Produto -> Quantidade");
            System.out.println("------------------------------------");

            for (Produto p : dados.getProdutos()) {
                System.out.print("| " + p.getNomeProduto());
                System.out.println(" -> " + p.getQuantidade());
            }
            System.out.println("------------------------------------");
            System.out.println("------------------------------------");
        }

        return ilegivel;
    }

    public static boolean verValor(Dados dados) {
        boolean ilegivel = true;
        if (dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n------------------------------------");
            System.out.println("| Produto -> Valor");
            System.out.println("------------------------------------");

            for (Produto p : dados.getProdutos()) {
                System.out.print("| " + p.getNomeProduto());
                System.out.println(" -> " + p.getValor());
            }
            System.out.println("------------------------------------");
            System.out.println("------------------------------------");
        }
        return ilegivel;

    }
    
}