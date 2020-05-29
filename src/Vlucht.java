package src;

public class Vlucht extends Node {
    String unit;

    public Vlucht(int id, String description){
        super(id);
        unit = description;
    }

    public String getUnit(){
        return unit;
    }
}