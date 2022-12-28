package storage;

import registration.Produto;
import java.util.ArrayList;

public class Dados extends Produto {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public Dados() {
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char sexo) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, sexo);
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char sexo, String numeracao) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, sexo, numeracao);
    }

    public Dados(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, char sexo, char estilo) {
        super(id, nomeProduto, quantidade, valor, tipoProduto, sexo, estilo);
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
