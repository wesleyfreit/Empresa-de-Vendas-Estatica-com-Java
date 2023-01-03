package menu;

import app.Empresa;
import menu.functions.Busca;
import registration.Produto;
public class Fornecer {

    public static void fornecimento() {
        int quantidade = 0;
        int idBuscado = Busca.buscaString();

        if(idBuscado != -1) {
            for (Produto p : Empresa.dados.getProdutos()) {
                if (p.getId() == idBuscado) {

                    System.out.print("\nInsira a nova quantidade a repor: ");
                    quantidade = Empresa.scanner.nextInt();

                    p.setQuantidade(quantidade);
                    
                    System.out.println("\nReposição concluída.");
                }
            }
        } else
            System.out.println("\nProduto não encontrado, tente visualizar a lista.");
    }
}