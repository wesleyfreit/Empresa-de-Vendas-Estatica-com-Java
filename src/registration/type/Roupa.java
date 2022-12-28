package registration.type;

public interface Roupa {
    int tipo = 2;
    String nome = "Roupa";

    String[] tamanhos = {"34", "36", "38", "40", "42", "44", "46", "48", "50", "PP", "P", "M", "G", "GG", "GGG"};

    String setTamanhoRoupa(String numeracao);
    String getTamanhoRoupa();
    void getTamanhosRoupa();
}
