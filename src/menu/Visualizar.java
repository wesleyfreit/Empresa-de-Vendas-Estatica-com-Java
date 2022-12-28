package menu;

import java.util.Scanner;
import registration.Produto;
import registration.type.*;
import storage.Dados;

public class Visualizar {

    public static void ver(Dados dados, Scanner scanner) {
        boolean run = true;

        do {
            System.out.println("\n------------------------\n| PRODUTOS CADASTRADOS |\n------------------------");
            System.out.print("1 - Ver Todos\n2 - Ver Produtos Estocados\n3 - Ver Valores de Produtos\n4 - Ver Produtos por Tipo\n5 - Voltar\n\nDigite: ");
            switch (scanner.nextInt()) {
                case 1:
                    if (verTudo(dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 2:
                    if (verQuantidade(dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 3:
                    if (verValor(dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 4:
                    System.out.println("Insira qual tipo de produto deseja ver");
                    System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
                    if(verPorTipo(scanner.nextInt(), dados))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("\nInsira uma opção válida");
                    break;
            }
        } while (run);
    }

    public static boolean verTudo(Dados dados){
        boolean ilegivel = true;

        if (dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n------------------------------------");
            System.out.println("| Tipo -> Público -> Produto -> Quantidade -> Valor");
            System.out.println("------------------------------------");

            for(Produto p : dados.getProdutos()){
                System.out.print("| " + p.getNomeProduto());
                System.out.print(" -> " + p.getPublico());
                System.out.print(" -> " + p.getTipoProduto());
                System.out.print(" -> " + p.getQuantidade());
                System.out.println(" -> " + p.getValor());
            }
            System.out.println("------------------------------------");
            System.out.println("------------------------------------");
        }
        return ilegivel;
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
    
    public static boolean verPorTipo(int n, Dados dados){
        boolean ilegivel = true;
        int x = 0;

        if(dados.sizeArray() > 0){
            ilegivel = false;

            String tipo = dados.setTipoProduto(n);

            System.out.println("\n-------------------------------------------------------");
            System.out.print("| Tipo -> Produto");
            
            
            for(Produto p : dados.getProdutos()){
                if(p.getTipoProduto() == tipo){
                    if(x != 1 && tipo == Perfume.nome){
                        System.out.println(" -> Intensidade -> Quantidade -> Valor");
                        System.out.println("-------------------------------------------------------");
                        x = 1;
                    } else if (x != 1 && tipo == Roupa.nome){
                        System.out.println(" -> Tamanho -> Quantidade -> Valor");
                        System.out.println("-------------------------------------------------------");
                        x = 1;
                    }

                    System.out.print("| " + p.getTipoProduto());
                    System.out.print(" -> " + p.getNomeProduto());
                    

                    if(tipo == Perfume.nome){
                        System.out.print(" -> " + p.getTipoPerfume());
                    } else {
                        System.out.print(" -> " + p.getTamanhoRoupa());
                    }

                    System.out.print(" -> " + p.getQuantidade());
                    System.out.println(" -> " + p.getValor());
                }  
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("-------------------------------------------------------");
        }
        return ilegivel;
    }
}