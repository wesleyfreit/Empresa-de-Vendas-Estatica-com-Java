package menu;

import app.Empresa;
import registration.Produto;
import registration.type.*;

public class Visualizar {

    public static void ver() {
        boolean run = true;

        do {
            System.out.println("\n------------------------\n| PRODUTOS CADASTRADOS |\n------------------------");
            System.out.print("1 - Ver Tudo\n2 - Ver Quantidade de Produtos\n3 - Ver Valores de Produtos\n4 - Ver Produtos pelo Tipo\n5 - Voltar\n\nDigite: ");
            switch (Empresa.scanner.nextInt()) {
                case 1:
                    if (verTudo())
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 2:
                    if (verQuantidade())
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 3:
                    if (verValor())
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 4:
                    System.out.println("\nInsira qual tipo de produto deseja ver");
                    System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
                    if(verPorTipo(Empresa.scanner.nextInt()))
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

    public static boolean verTudo(){
        boolean ilegivel = true;

        if (Empresa.dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n---------------------------------------------------");
            System.out.println("| Tipo -> Público -> Produto -> Quantidade -> Valor");
            System.out.println("---------------------------------------------------");

            for(Produto p : Empresa.dados.getProdutos()){
                System.out.print("| " + p.getNomeProduto());
                System.out.print(" -> " + p.getPublico());
                System.out.print(" -> " + p.getTipoProduto());
                System.out.print(" -> " + p.getQuantidade());
                System.out.println(" -> " + p.getValor());
            }
            System.out.println("---------------------------------------------------");
            System.out.println("---------------------------------------------------");
        }
        return ilegivel;
    }

    public static boolean verQuantidade() {
        boolean ilegivel = true;

        if (Empresa.dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n--------------------------");
            System.out.println("| Produto -> Quantidade");
            System.out.println("--------------------------");

            for (Produto p : Empresa.dados.getProdutos()) {
                System.out.print("| " + p.getNomeProduto());
                System.out.println(" -> " + p.getQuantidade());
            }
            System.out.println("--------------------------");
            System.out.println("--------------------------");
        }
        return ilegivel;
    }

    public static boolean verValor() {
        boolean ilegivel = true;
        if (Empresa.dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n--------------------------");
            System.out.println("| Produto -> Valor");
            System.out.println("--------------------------");

            for (Produto p : Empresa.dados.getProdutos()) {
                System.out.print("| " + p.getNomeProduto());
                System.out.println(" -> " + p.getValor());
            }
            System.out.println("--------------------------");
            System.out.println("--------------------------");
        }
        return ilegivel;
    }
    
    public static boolean verPorTipo(int n){
        boolean ilegivel = true;
        int x = 0;

        if(Empresa.dados.sizeArray() > 0 && Empresa.dados.searchValues(n) > 0){
            ilegivel = false;
            
            String tipo = Empresa.dados.setTipoProduto(n);

            System.out.println("\n-------------------------------------------------------");
            System.out.print("| Tipo -> Produto");
            
            for(Produto p : Empresa.dados.getProdutos()){
                if(p.getTipoProduto() == tipo){
                    if(x != 1 && tipo == Perfume.nome){
                        System.out.println(" -> Cheiro -> Quantidade -> Valor");
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