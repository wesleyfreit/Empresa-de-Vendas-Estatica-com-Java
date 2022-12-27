package registration;

import registration.type.Perfume;
import registration.type.Roupa;

public abstract class Produto implements Perfume, Roupa {

    private int id;
    private String nomeProduto;
    private int quantidade = 0;
    private double valor;
    private String tipoProduto;
    private String numeracao;

    public Produto() {
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, int tipoProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor, int tipoProduto, String numeracao) {
        this(id, nomeProduto, quantidade, valor, tipoProduto);
        this.numeracao = numeracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public String getTipoProduto(){
        return tipoProduto;
    }

    public String setTipoProduto(int tipoProduto) {
        return this.tipoProduto = (tipoProduto == Perfume.tipo) ? Perfume.nome : Roupa.nome;
    }

    public void setTamanhoRoupa(String numeracao) {
        this.numeracao = numeracao;   
    }
    
    public String getTamanhoRoupa() {
        return numeracao;
    }

}
