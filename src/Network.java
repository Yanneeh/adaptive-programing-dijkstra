package src;

import java.util.ArrayList;
import java.util.List;

public class Network {

    List<Node> nodes = new ArrayList<Node>();

    public void loadCustomNetwork(){
        // Load custom network.
        // TODO: add file reading for custom protocol.
    }

    public void setupDefaultNetwork(){  

        // Create nodes.
        for(int i = 0; i < 5; i++){
            nodes.add(new Node(i+1));
        }

        // Setup default network.
        nodes.get(0).addConnection(new Connection(nodes.get(1), 2));
        nodes.get(0).addConnection(new Connection(nodes.get(3), 6));
        nodes.get(3).addConnection(new Connection(nodes.get(0), 6));
        nodes.get(3).addConnection(new Connection(nodes.get(2), 4));
        nodes.get(3).addConnection(new Connection(nodes.get(4), 8));
        nodes.get(1).addConnection(new Connection(nodes.get(0), 2));
        nodes.get(1).addConnection(new Connection(nodes.get(2), 10));
        nodes.get(2).addConnection(new Connection(nodes.get(1), 10));
        nodes.get(2).addConnection(new Connection(nodes.get(3), 4));
        nodes.get(2).addConnection(new Connection(nodes.get(4), 6));

        // Set end node.
        nodes.get(4).setEndNode(true);
    }

    Node getLowestCostNode(){

        Node lowestCostNode = null;

        // Select first node that is not visited.
        for (int i = 0; i < nodes.size(); i++){
            if (!nodes.get(i).isVisited){
                lowestCostNode = nodes.get(i);
                break;
            }
        }
        
        if (lowestCostNode != null){
            for (int i = 0; i < nodes.size(); i++){

                // Check if the cost of a new node is smaller than the cost of the last lowest cost node.
                if (nodes.get(i).cost < lowestCostNode.cost){

                    // Check if node is already visited.
                    if (!nodes.get(i).isVisited){

                        // Make this node the new lowest cost node.
                        lowestCostNode = nodes.get(i);
                    }
                }
            }
    
            lowestCostNode.isVisited = true;
    
            return lowestCostNode;
            
        } else {
            return null;
        }
    }

    public Route travelNetwork(int beginNodeId, int endNodeId){

        if(beginNodeId != endNodeId){

            Node currentNode = null;
            boolean reachable = false;

            for(int i = 0; i < nodes.size(); i++){
                if(nodes.get(i).getId() == beginNodeId){
                    
                    // Set the start node.
                    currentNode = nodes.get(i);

                    currentNode.cost = 0;

                } else if (nodes.get(i).getId() == endNodeId){

                    // Set the end node.
                    nodes.get(i).setEndNode(true);
                    reachable = true;
                }
            }

            if (currentNode != null){

                if (reachable){

                    // Find shortest path.
                    while(true){

                        currentNode.updateCosts();

                        currentNode = getLowestCostNode();

                        if(currentNode.isEndNode()){
                            break;
                        }
                    }

                    // Record shortest path.
                    while(true){

                        if (currentNode.id == beginNodeId){
                            break;
                        }

                        currentNode = currentNode.previousNode;

                        // Add node to route

                        System.out.println(currentNode.getId());
                    }
                    
                    return new Route();

                } else {
                    System.out.println("Endnode does not exist");
                    return null;
                }
            } else {
                System.out.println("BeginNode does not exist");
                return null;
            }
        } else {
            System.out.println("Not a valid path");
            return null;
        }
    }
}