package menu;

import app.Empresa;
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
                            System.out.println("\nProduto inexistente, tente visualizar a lista.");
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

    public static boolean fazerVenda(){
        boolean ilegivel = true;

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o nome do produto: ");
        String nomeProduto =  Empresa.scanner.nextLine();

        System.out.print("Insira a quantidade: ");
        int quantidade = Empresa.scanner.nextInt();

        for(Produto p : Empresa.dados.getProdutos()){
            if(p.getNomeProduto().equalsIgnoreCase(nomeProduto)){
                ilegivel = false;
                
                if(p.getQuantidade() >= quantidade){
                    p.setQuantidade(-quantidade);

                    System.out.println("\nVenda efetuada com sucesso.");
                    System.out.println("\n------------------------------------");
                    System.out.println("Produto: " + p.getNomeProduto());
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Valor Total: R$" + p.getValor() * quantidade);
                    System.out.println("------------------------------------");
                } else {
                    System.out.println("\nNão existe essa quantidade no estoque, verifique-o e tente novamente.");
                }
            }
        }
        return ilegivel;
    }
}