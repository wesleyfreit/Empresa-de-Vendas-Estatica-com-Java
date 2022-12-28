package registration.type;

public interface Perfume {
    int tipo = 1;
    String nome = "Perfume";

    Character[] tipos = {'F', 'H', 'C', 'A', 'E', 'T'};
    String[] tiposFull = {"Floral", "Herbal", "Cítrico", "Amadeirado", "Especiaria","Terroso"};
    
    String setTipoPerfume(Character tipoPerfume);
    String getTipoPerfume();
    void getTiposPerfume();

}
