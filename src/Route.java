package src;

import java.util.List;
import java.util.ArrayList;

public class Route {
    List<Node> nodes = new ArrayList<Node>();
    float cost = 0;

    public void addNode(Node node){
        nodes.add(0, node);
    }

    public Node getNode(int index){
        return nodes.get(index);
    }

    public float getCost(){
        return cost;
    }

	public void setCost(float amount) {
        cost = amount;
    }

}