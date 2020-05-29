package src;

public class TreinRit extends Node {
    String unit;

    public TreinRit(int id, String description){
        super(id);
        unit = description;
    }

    public String getUnit(){
        return unit;
    }
}