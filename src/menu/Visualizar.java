package menu;

import app.Empresa;
import menu.functions.Busca;
import registration.Produto;
import registration.type.*;

public class Visualizar {

    public static void ver() {
        boolean run = true;

        do {
            System.out.println("\n------------------------\n| PRODUTOS CADASTRADOS |\n------------------------");
            System.out.print("1 - Ver Tudo\n2 - Ver por Tipo\n3 - Pesquisar Nome\n4 - Voltar\n\nDigite: ");
            switch (Empresa.scanner.nextInt()) {
                case 1:
                    if (verTudo())
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 2:
                    System.out.println("\nInsira qual tipo de produto deseja ver");
                    System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
                    int n = Empresa.scanner.nextInt();
                    if(n!=1 && n!=2)
                        System.out.println("\nValor inválido");
                    else if(verPorTipo(n))
                        System.out.println("\nNão há produtos cadastrados.");
                    break;
                case 3:
                    int idBuscado = Busca.buscaString();
                    verProduto(idBuscado);
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

    public static boolean verTudo(){
        boolean ilegivel = true;

        if (Empresa.dados.sizeArray() > 0) {
            ilegivel = false;

            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("| Produto -> Público -> Quantidade -> Valor -> Tipo -> Tamanho/Cheiro");
            System.out.println("---------------------------------------------------------------------");

            for(Produto p : Empresa.dados.getProdutos()){
                System.out.print("| " + p.getNomeProduto());
                System.out.print(" -> " + p.getPublico());
                System.out.print(" -> " + p.getQuantidade());
                System.out.print(" -> " + p.getValor());
                System.out.print(" -> " + p.getTipoProduto());
                if(p.getTipoProduto() == Perfume.nome)
                    System.out.println(" -> " + p.getTipoPerfume());
                else
                    System.out.println(" -> " + p.getTamanhoRoupa());
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
        }
        return ilegivel;
    }

    public static boolean verPorTipo(int n){
        boolean ilegivel = true;
        int x = 0;

        if(Empresa.dados.sizeArray() > 0 && Empresa.dados.searchValues(n) > 0){
            ilegivel = false;
            
            String tipo = Empresa.dados.setTipoProduto(n);

            System.out.println("\n------------------------------------------------------");
            System.out.print("| Produto -> Público -> Quantidade -> Valor");
            
            for(Produto p : Empresa.dados.getProdutos()){
                if(p.getTipoProduto() == tipo){
                    if(x != 1 && tipo == Perfume.nome){
                        System.out.println(" -> Cheiro");
                        System.out.println("------------------------------------------------------");
                        x = 1;
                    } else if (x != 1 && tipo == Roupa.nome){
                        System.out.println(" -> Tamanho");
                        System.out.println("------------------------------------------------------");
                        x = 1;
                    }
                    System.out.print("| " + p.getNomeProduto());
                    System.out.print(" -> " + p.getPublico());
                    System.out.print(" -> " + p.getQuantidade());
                    System.out.print(" -> " + p.getValor());

                    if(tipo == Perfume.nome){
                        System.out.println(" -> " + p.getTipoPerfume());
                    } else {
                        System.out.println(" -> " + p.getTamanhoRoupa());
                    }
                }  
            }
            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
        }
        return ilegivel;
    }

    public static void verProduto(int idBuscado) {
    
        if(idBuscado != -1) {
            System.out.println("\n--------------------------------------------------------------");
            System.out.print("| Produto -> Tipo -> Público -> Quantidade -> Valor");
            for(Produto p : Empresa.dados.getProdutos()) {
                if(p.getId() == idBuscado) {
                    if(p.getTipoProduto() == Perfume.nome){
                        System.out.println(" -> Cheiro");
                        System.out.println("--------------------------------------------------------------");
                    } else if(p.getTipoProduto() == Roupa.nome) {
                        System.out.println(" -> Tamanho");
                        System.out.println("--------------------------------------------------------------");
                    }
                    
                    System.out.print("| " + p.getNomeProduto());
                    System.out.print(" -> " + p.getTipoProduto());
                    System.out.print(" -> " + p.getPublico());
                    System.out.print(" -> " + p.getQuantidade());
                    System.out.print(" -> " + p.getValor());
                    if(p.getTipoProduto() == Perfume.nome)
                        System.out.println(" -> " + p.getTipoPerfume());
                    else
                        System.out.println(" -> " + p.getTamanhoRoupa());

                    System.out.println("--------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------");
                }
            }
        } else 
            System.out.println("\nProduto não encontrado, tente visualizar a lista.");
    }
}