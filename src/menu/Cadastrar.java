package menu;

import java.util.Scanner;
import registration.type.*;
import storage.Dados;

public class Cadastrar {

    public static void cadastro(Dados dados, int id, Scanner scanner) {

        String nomeProduto;
        int quantidade;
        double valor;
        int tipoProduto;
        String numeracao;
        char sexo;
        char estilo;

        System.out.println("Insira o tipo de produto a ser cadastrado");
        System.out.print("\n1 - Perfume\n2 - Roupa\n\nDigite: ");
        tipoProduto = scanner.nextInt();

        scanner.nextLine();
        System.out.print("\nInsira o nome do produto para cadastrá-lo: ");
        nomeProduto = scanner.nextLine();

        System.out.print("Insira a quantidade para ser estocada: ");
        quantidade = scanner.nextInt();

        System.out.print("Insira o valor de venda do produto: ");
        valor = scanner.nextDouble();

        if(tipoProduto == Roupa.tipo){
            scanner.nextLine();
            System.out.print("Qual a numeração(tamanho) da peça? ");
            numeracao = scanner.next();

            System.out.print("A peça é feminina(F) ou masculina(M)? ");
            sexo = scanner.next().charAt(0);

            Dados produto = new Dados(id, nomeProduto, quantidade, valor, tipoProduto, sexo, numeracao);
            dados.cadastroProduto(produto);
        } else {
            scanner.nextLine();
            System.out.print("O perfume é Forte(F) ou Suave(S)? ");
            estilo = scanner.next().charAt(0);

            scanner.nextLine();
            System.out.print("O perfume é feminino(F) ou masculino(M)? ");
            sexo = scanner.next().charAt(0);

            Dados produto = new Dados(id, nomeProduto, quantidade, valor, tipoProduto, sexo, estilo);
            dados.cadastroProduto(produto);
        }
        
        System.out.println("\nProduto Cadastrado.");
    }
}