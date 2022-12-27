package registration.type;

public interface Roupa {
    public static final int tipo = 2;
    public static final String nome = "Roupa";

    public abstract void setTamanhoRoupa(String numeracao);
    public abstract String getTamanhoRoupa();
}
