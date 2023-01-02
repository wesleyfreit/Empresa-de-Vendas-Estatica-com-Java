package menu;

import app.Empresa;
import registration.Produto;

public class Atualizar {

    public static void atualizacao() {
        boolean run = true;

        do {
            System.out.println("\n---------------\n| ATUALIZAÇÃO |\n---------------");
            System.out.print("1 - Alterar Preço de um Produto\n2 - Atualizar Nome de um Produto\n3 - Visualizar Lista de Produtos\n4 - Voltar\n\nDigite: ");
            switch (Empresa.scanner.nextInt()) {
                case 1:
                    if (altValor())
                        System.out.println("\nProduto inexistente, tente visualizar a lista.");
                    break;
                case 2:
                    if (altNome())
                        System.out.println("\nProduto inexistente, tente visualizar a lista.");
                    break;   
                case 3:
                    Visualizar.ver();
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

    public static boolean altNome(){
        boolean ilegivel = true;

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o nome atual do produto: ");
        String nomeProduto = Empresa.scanner.nextLine();

        for (Produto p : Empresa.dados.getProdutos()) {
            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                ilegivel = false;

                System.out.println("\nProduto encontrado.");
                System.out.print("\nInsira o novo nome do produto: ");
                String newNomeProduto = Empresa.dados.setFirstUpperCase(Empresa.scanner.nextLine());
                
                p.setNomeProduto(newNomeProduto);
                System.out.println("\nNome alterado com sucesso.");
            }
        }
        return ilegivel;
    }

    public static boolean altValor(){
        boolean ilegivel = true;

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o nome do produto: ");
        String nomeProduto = Empresa.scanner.nextLine();

        for (Produto p : Empresa.dados.getProdutos()) {
            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                ilegivel = false;

                System.out.println("\nProduto encontrado.");

                System.out.print("\nInsira o novo valor para o produto: ");
                double newValorProduto = Empresa.scanner.nextDouble();

                p.setValor(newValorProduto);

                System.out.println("\nValor alterado com sucesso.");
            }
        }
        return ilegivel;
    }
}