package menu;

import app.Empresa;
import registration.Produto;
import menu.functions.*;
public class Atualizar {

    public static void atualizacao() {
        boolean run = true;

        do {
            System.out.println("\n---------------\n| ATUALIZAÇÃO |\n---------------");
            System.out.print("1 - Alterar Preço de um Produto\n2 - Atualizar Nome de um Produto\n3 - Visualizar Lista de Produtos\n4 - Voltar\n\nDigite: ");
            switch (Empresa.scanner.nextInt()) {
                case 1:
                    if (altValor())
                        System.out.println("\nProduto não encontrado, tente visualizar a lista.");
                    break;
                case 2:
                    if (altNome())
                        System.out.println("\nProduto não encontrado, tente visualizar a lista.");
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
        int idBuscado = Busca.buscaString();

        if(idBuscado != -1) {
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getId() ==idBuscado) {
                    ilegivel = false;

                    Empresa.scanner.nextLine();
                    System.out.print("\nInsira o novo nome do produto: ");
                    String newNomeProduto = Empresa.dados.setTittleCaseString(Empresa.scanner.nextLine());

                    if(p.getNomeProduto().equalsIgnoreCase(newNomeProduto))
                        System.out.println("\nOperação abortada, o novo nome não pode ser igual ao nome atual");
                    else {
                        p.setNomeProduto(newNomeProduto);
                        System.out.println("\nNome alterado com sucesso.");
                    }
                }
            }  
        }
        return ilegivel;
    }

    public static boolean altValor(){
        boolean ilegivel = true;
        int idBuscado = Busca.buscaString();

        if(idBuscado != -1) {
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getId() ==idBuscado) {
                    ilegivel = false;

                    System.out.print("\nInsira o novo valor para o produto: ");
                    double newValorProduto = Empresa.scanner.nextDouble();

                    if(newValorProduto != p.getValor() && newValorProduto >= 0){
                        p.setValor(newValorProduto);
                        System.out.println("\nValor alterado com sucesso.");
                    } else {
                        System.out.println("\nOperação abortada, o valor não pode ser menor que zero ou igual ao valor já existente.");
                    }
                }
            }
        }
        return ilegivel;
    }
}