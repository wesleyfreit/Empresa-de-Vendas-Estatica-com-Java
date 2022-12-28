package registration.type;

public interface Perfume {
    int tipo = 1;
    String nome = "Perfume";

    char tipoPerfume1 = 'S';
    char tipoPerfume2 = 'F';

    String suave = "Suave";
    String forte = "Forte";
    
    String setTipoPerfume(char tipoPerfume);
    String getTipoPerfume();

}
