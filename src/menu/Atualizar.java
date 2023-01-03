package menu;

import java.util.List;

import app.Empresa;
import registration.Produto;

public class Atualizar {

    public static void atualizacao() {
        boolean run = true;

        do {
            System.out.println("\n---------------\n| ATUALIZAÇÃO |\n---------------");
            System.out.print("1 - Alterar Preço de um Produto\n2 - Atualizar Nome de um Produto"
                + "\n3 - Visualizar Lista de Produtos\n4 - Voltar\n\nDigite: ");
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
        String nomeBuscado = exibicaoBuscaString();

        if(nomeBuscado != null){
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getNomeProduto().equalsIgnoreCase(nomeBuscado)) {
                    ilegivel = false;

                    System.out.println("\nProduto Encontrado.");
                    Empresa.scanner.nextLine();
                    System.out.print("\nInsira o novo nome do produto: ");
                    String newNomeProduto = Empresa.dados.setTittleCaseString(Empresa.scanner.nextLine());

                    if(p.getNomeProduto().equalsIgnoreCase(newNomeProduto)){
                        System.out.println("\nOperação abortada, o novo nome não pode ser igual ao nome atual");
                    } else {
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
        String nomeBuscado = exibicaoBuscaString();

        if(nomeBuscado != null){
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getNomeProduto().equalsIgnoreCase(nomeBuscado)) {
                    ilegivel = false;

                    System.out.println("\nProduto encontrado.");

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

    public static String exibicaoBuscaString() {

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o atual do produto que deseja buscar: ");
        String nomeProduto = Empresa.scanner.nextLine();

        List<Produto> resultadoBusca = Empresa.dados.busca(nomeProduto);
        
        if(resultadoBusca.size() > 0){
            System.out.println("\nProdutos Encontrados\n");

            System.out.println("\n------------------------------------");
            System.out.println("| Id -> Produto -> Preço");
            System.out.println("------------------------------------");

            for(Produto p : resultadoBusca){
                System.out.println("| " + p.getId() + " -> " + p.getNomeProduto() + " -> " + p.getValor());
            }
            System.out.println("------------------------------------");

            System.out.print("\nDigite o id correspondente da lista: ");
            int numero = Empresa.scanner.nextInt();
    
            String nomeBuscado = Empresa.dados.busca(nomeProduto, numero);

            return nomeBuscado;
        }
        return null;
    }
}