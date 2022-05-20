////////////////////////////////////////////////////////////////////
// Pietro Marcatti 1226283
// Davide Spada 1220539
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class RealEItem implements EItem {

    private String name;

    private EItemType type;

    private Double price;

    public RealEItem(String name, EItemType type, Double price) {
        if(name == null) {
            throw new IllegalArgumentException("Nome nullo non valido");
        }
        if(type == null) {
            throw new IllegalArgumentException("Tipo nullo non valido");
        }
        if(price == null) {
            throw new IllegalArgumentException("Prezzo nullo non valido");
        }
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItemType getEItemType() {
        return type;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
