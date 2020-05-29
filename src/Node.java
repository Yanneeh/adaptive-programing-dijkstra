package src;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    int id;
    boolean isVisited = false;
    boolean isEndNode = false;
    Node previousNode;
    float cost = Float.POSITIVE_INFINITY;
    List<Connection> connections = new ArrayList<Connection>();

    public Node(int number){
        id = number;
    }

    public int getId(){
        return id;
    }

    public void setCost(float amount){
        cost = amount;
    }

    public float getCost(){
        return cost;
    }

    public void setPreviousNode(Node node){
        previousNode = node;
    }

    public Node getPreviousNode(){
        return previousNode;
    }

    public void setVisited(boolean state){
        isVisited = state;
    }

    public boolean isVisited(){
        return isVisited;
    }

    public void setEndNode(boolean state){
        isEndNode = state;
    }

    public boolean isEndNode(){
        return isEndNode;
    }
    
    public void addConnection(Connection connection){
        connections.add(connection);
    }

    public void updateCosts(){
        for (int i = 0; i < connections.size(); i++){

            // Get the current connection.
            Connection currentConnection = connections.get(i);

            // Get the new cost of the node.
            float newCost = cost + currentConnection.distance;

            // Check if the new cost is smaller than the old cost.
            if (newCost < currentConnection.node.cost){

                // Update the cost of the node.
                currentConnection.node.setCost(newCost);

                // Update the previous node to be this node.
                currentConnection.node.setPreviousNode(this);
            }
        }
    }

}