package storage;

import registration.Produto;
import java.util.ArrayList;

public class Dados extends Produto {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public Dados() {
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, String tipoProduto, char publico) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, publico);
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, String tipoProduto, char publico, String tipoTamanho) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, publico, tipoTamanho);
    }

    public void cadastroProduto(Produto prod) {
        produtos.add(prod);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public int sizeArray() {
        return produtos.size();
    }

    public int searchValues(int n){
        int reg = 0;

        String tipo = setTipoProduto(n);

        for(Produto p : getProdutos()){
            if(p.getTipoProduto().equals(tipo)){
                reg++;
            }
        }
        return reg;
    }
}
