package storage;

import registration.Produto;
import java.util.ArrayList;

public class Dados extends Produto {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public Dados() {
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, int tipo) {
        super(id, nomeProduto, quantidade, valor, tipo);
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, String numeracao) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, numeracao);
    }

    public void cadastroProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public int sizeArray() {
        return produtos.size();
    }
}
