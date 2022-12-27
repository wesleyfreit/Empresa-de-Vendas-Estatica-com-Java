import storage.Dados;
import menu.*;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Dados dados = new Dados();
        boolean run = true;
        int id = 1;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println(
                        "\n--------\n| MENU |\n--------\n1 - Vender Produto(s)\n2 - Visualizar Produto(s)\n3 - Cadastrar Novo(s) Produto(s)\n4 - Repor Produto(s)\n5 - Editar Produto(s)\n6 - Sair do Programa");
                System.out.print("\nInsira uma opção: ");

                switch (scanner.nextInt()) {
                    case 1:
                        Vender.venda(dados, scanner);
                        break;
                    case 2:
                        Visualizar.ver(dados, scanner);
                        break;
                    case 3:
                        Cadastrar.cadastro(dados, id, scanner);
                        id++;
                        break;
                    case 4:
                        Fornecer.fornecimento(dados, scanner);
                        break;
                    case 5:
                        Atualizar.atualizacao(dados, scanner);
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