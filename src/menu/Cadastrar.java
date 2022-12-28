package menu;

import java.util.Scanner;
import registration.type.*;
import storage.Dados;

public class Cadastrar {

    public static void cadastro(Dados dados, int id, Scanner scanner) {

        String nomeProduto;
        int quantidade;
        double valor;
        String tipoProduto;
        String tamanhoTipo;
        Character publico;

        System.out.println("\n---------------------\n| CADASTRAR PRODUTO |\n---------------------");
        System.out.println("\nInsira os Dados do Produto");

        tipoProduto = setTipoProduto(scanner, dados);

        scanner.nextLine();
        System.out.print("\nNome: ");
        nomeProduto = scanner.nextLine();

        System.out.print("Valor de Venda: ");
        valor = scanner.nextDouble();

        System.out.print("Quantidade para Estocar: ");
        quantidade = scanner.nextInt();

        if(tipoProduto == Roupa.nome){
            tamanhoTipo = setTamanhoRoupa(scanner, dados);

            System.out.print("\nA peça é feminina(F) ou masculina(M)? "); 
        } else {
            tamanhoTipo = setTipoPerfume(scanner, dados);

            scanner.nextLine();
            System.out.print("\nO perfume é feminino(F) ou masculino(M)? ");
        }

        publico = scanner.next().charAt(0);

        Dados produto = new Dados(id, nomeProduto, quantidade, valor, tipoProduto, publico, tamanhoTipo);
        dados.cadastroProduto(produto);
        
        System.out.println("\nProduto Cadastrado.");
    }

    public static String setTipoProduto(Scanner scanner, Dados dados) {
        String tipo;
        boolean run = true;

        do{
            System.out.println("\nInsira o tipo de produto a ser cadastrado");
            System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
            tipo = dados.setTipoProduto(scanner.nextInt());

            if(tipo != null){
                run = false;
            } else {
                System.out.println("\nValor inválido, tente novamente.");
            }

        } while(run);
        return tipo;
    }

    public static String setTamanhoRoupa(Scanner scanner, Dados dados) {
        String numeracao;
        String tamanhoRoupa = null;
        boolean run = true;
        do {
            System.out.println("\nQual a numeração ou tamanho da peça?");
            System.out.print("\n1 - Ver Numerações\n2 - Inserir Numeração\n\nDigite: ");
            
            switch(scanner.nextInt()){
                case 1:
                    dados.getTamanhosRoupa();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("\nNumeração ou tamanho da peça: ");
                    numeracao = scanner.next();
                    tamanhoRoupa = dados.setTamanhoRoupa(numeracao);

                    if(tamanhoRoupa != null) {
                        run = false;
                    } else {
                        System.out.println("\nValor inválido, tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Número inválido, tente novamente.");
                    break;
            }
        } while(run);

        return tamanhoRoupa;
    }

    public static String setTipoPerfume(Scanner scanner, Dados dados) {
        Character tipo;
        String tipoFull = null;
        boolean run = true;
        do {
            System.out.println("\nQual é o tipo de perfume?");
            System.out.print("\n1 - Ver Tipos\n2 - Inserir Tipo\n\nDigite: ");
            
            switch(scanner.nextInt()){
                case 1:
                    dados.getTiposPerfume();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("\nTipo de perfume: ");
                    tipo = scanner.next().charAt(0);
                    tipoFull = dados.setTipoPerfume(tipo);

                    if(tipoFull != null) {
                        run = false;
                    } else {
                        System.out.println("\nValor inválido, tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Número inválido, tente novamente.");
                    break;
            }
        } while(run);

        return tipoFull;
    }
}