package menu;

import java.util.Scanner;
import storage.Dados;

public class Cadastrar {

    public static void cadastro(Dados dados, int id, Scanner scanner) {
        String nomeProduto;
        int quantidade;
        double valor;

        scanner.nextLine();
        System.out.print("\nInsira o nome do produto para cadastrá-lo: ");
        nomeProduto = scanner.nextLine();

        System.out.print("Insira a quantidade para ser estocada: ");
        quantidade = scanner.nextInt();

        System.out.print("Insira o valor de venda do produto: ");
        valor = scanner.nextDouble();

        Dados produto = new Dados(id, nomeProduto, quantidade, valor);
        dados.cadastroProduto(produto);
        System.out.println("\nProduto Cadastrado.");
    }
}