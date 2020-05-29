package src;

public class Connection {
    
    Node node;
    float distance;

    public Connection(Node connected, float amount){
        node = connected;
        distance = amount;
    }
}