package menu;

import app.Empresa;
import menu.functions.Busca;
import registration.Produto;

public class Vender {

    public static void venda() {
        boolean run = true;
        
        do{
            System.out.print("\n---------\n| VENDA |\n---------\n1 - Fazer Venda\n2 - Visualizar Lista de Produtos\n3 - Voltar\n\nDigite: ");
            
            switch(Empresa.scanner.nextInt()){
                case 1:
                    if(Empresa.dados.sizeArray() > 0) {
                        if(fazerVenda())
                            System.out.println("\nProduto não encontrado, tente visualizar a lista.");
                    } else
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 2:
                    Visualizar.ver();
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("\nInsira uma opção válida");
                    break;
            }
        } while(run);
    }

    public static boolean fazerVenda() {
        boolean ilegivel = true;
        int idBuscado = Busca.buscaString();

        if(idBuscado != -1){
            for(Produto p : Empresa.dados.getProdutos()) {
                if(p.getId() == idBuscado){
                    ilegivel = false;

                    System.out.print("\nInsira a quantidade: ");
                    int quantidade = Empresa.scanner.nextInt();

                    if(p.getQuantidade() >= quantidade && quantidade > 0) {
                        p.setQuantidade(-quantidade);
    
                        System.out.println("\nVenda efetuada com sucesso");
                        System.out.println("------------------------------------");
                        System.out.println("Produto: " + p.getNomeProduto());
                        System.out.println("Quantidade: " + quantidade);
                        System.out.println("Valor Total: R$" + p.getValor() * quantidade);
                        System.out.println("------------------------------------");
                    } else if(quantidade <= 0)
                        System.out.println("\nOperação abortada, impossível vender zero ou menos produtos.");
                    else if(p.getQuantidade() < quantidade)
                        System.out.println("\nNão existe essa quantidade no estoque, verifique-o e tente novamente.");
                }
            }
        }
        return ilegivel;
    }
}