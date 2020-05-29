package src;

public class Rit extends Node {

    String unit;

    public Rit(int id, String description){
        super(id);
        unit = description;
    }

    public String getUnit(){
        return unit;
    }
}