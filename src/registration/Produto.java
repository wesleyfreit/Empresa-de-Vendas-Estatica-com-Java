package registration;

public abstract class Produto {

    private int id;
    private String nomeProduto;
    private int quantidade = 0;
    private double valor;

    public Produto() {
    }

    public Produto(int id, String nomeProduto, int quantidade, double valor) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
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

}
