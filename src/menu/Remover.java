package menu;

import app.Empresa;
import menu.functions.Busca;
import registration.Produto;

public class Remover {
    public static void remocao(){
        boolean run = true;

        do {
            System.out.println("\n---------------\n| REMOÇÃO |\n---------------");
            System.out.print("1 - Remover um Produto\n2 - Visualizar Lista de Produtos\n3 - Remover Tudo\n4 - Voltar\n\nDigite: ");
            switch (Empresa.scanner.nextInt()) {
                case 1:
                    if (removerProduto())
                        System.out.println("\nProduto não encontrado, tente visualizar a lista.");
                    break;
                case 2:
                    Visualizar.ver();
                    break;   
                case 3:
                    removerTudo();
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

    public static boolean removerProduto() {
        boolean ilegivel = true;
        int idBuscado = Busca.buscaString();
        boolean run = true;

        if(idBuscado != -1) {
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getId() ==idBuscado) {
                    ilegivel = false;
                    do {
                        System.out.println("\nTem certeza que deseja remover " + p.getNomeProduto() + "?");
                        System.out.print("\n1 - Sim\n2 - Não\n\nDigite: ");
                        switch(Empresa.scanner.nextInt()) {
                            case 1:
                                Empresa.dados.getProdutos().remove(p);
                                System.out.println("\nProduto removido com sucesso.");
                                run = false;
                                break;
                            case 2:
                                System.out.println("\nProduto não removido.");
                                run = false;
                                break;
                            default:
                                System.out.println("\nValor inválido, tente novamente");
                        }
                    } while(run);

                    break;
                }    
            } 
        }
        return ilegivel;
    }

    public static void removerTudo() {
        boolean run = true;
        do {
            System.out.println("\nATENÇÃO: A REMOÇÃO DE TODOS OS PRODUTOS CONSISTE EM ZERAR A LISTA DE PRODUTOS.");
            System.out.println("\nTem certeza que deseja remover tudo?");
            
            System.out.print("\n1 - Sim\n2 - Não\n\nDigite: ");
            switch(Empresa.scanner.nextInt()) {
                case 1:
                    Empresa.dados.getProdutos().clear();
                    System.out.println("\nTodos os produtos foram removidos.");
                    run = false;
                    break;
                case 2:
                    System.out.println("\nOperação abortada.");
                    run = false;
                    break;
                default:
                    System.out.println("\nValor inválido, tente novamente");
            }
        } while(run);
    }
}