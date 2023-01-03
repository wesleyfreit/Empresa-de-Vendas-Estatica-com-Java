package app;

import menu.*;
import storage.Dados;

import java.util.Scanner;
public class Empresa {

    public static Dados dados = new Dados();
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int id = 1;
        boolean run = true;
        
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println(
                        "\n--------\n| MENU |\n--------\n1 - Vender Produto(s)\n2 - Visualizar Produto(s)\n3 - Cadastrar Novo(s) Produto(s)\n4 - Repor Produto(s)\n5 - Editar Produto(s)\n6 - Sair do Programa");
                System.out.print("\nInsira uma opção: ");

                switch (scanner.nextInt()) {
                    case 1:
                        Vender.venda();
                        break;
                    case 2:
                        Visualizar.ver();
                        break;
                    case 3:
                        Cadastrar.cadastro(id);
                        id++;
                        break;
                    case 4:
                        Fornecer.fornecimento();
                        break;
                    case 5:
                        Atualizar.atualizacao();
                        break;
                    case 6:
                        System.out.println("\nPrograma Finalizado.\n");
                        run = false;
                        scanner.close();
                        break;
                    default:
                        System.out.println("\nInsira um valor válido.");
                        new java.util.Scanner(System.in).nextLine();
                        break;
                }
            } while (run);
        }
    }
}