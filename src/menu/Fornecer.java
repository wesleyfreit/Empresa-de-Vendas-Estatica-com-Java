package menu;

import app.Empresa;
import registration.Produto;
public class Fornecer {

    public static void fornecimento() {
        String nomeProduto;
        int quantidade = 0;

        Empresa.scanner.nextLine();
        System.out.print("\nInsira o nome do produto que deseja buscar: ");
        nomeProduto = Empresa.scanner.nextLine();

        boolean verification = true;

        for (Produto p : Empresa.dados.getProdutos()) {

            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                
                verification = false;

                System.out.println("\nProduto Encontrado.");
                System.out.print("\nInsira a nova quantidade a repor: ");
                quantidade = Empresa.scanner.nextInt();

                p.setQuantidade(quantidade);
                
                System.out.println("\nReposição concluída.");
            }
        }
        if (verification) {
            System.out.println("\nProduto Inexistente.");
        }
    }
}