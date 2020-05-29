package tests;
import src.*;

import static org.junit.Assert.assertEquals;

public class TestNode {

    // Test netwerk op basis van een uitgewerkt theoretisch testnetwerk.

    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node node5;
    Node node6;
    Node node7;
    
    public void setupTest(){

        // Create nodes.
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);        

        // Setup test network.
        node1.addConnection(new Connection(node2, 2));
        node1.addConnection(new Connection(node4, 6));
        node4.addConnection(new Connection(node1, 6));
        node4.addConnection(new Connection(node3, 4));
        node4.addConnection(new Connection(node5, 8));
        node2.addConnection(new Connection(node1, 2));
        node2.addConnection(new Connection(node3, 10));
        node3.addConnection(new Connection(node2, 10));
        node3.addConnection(new Connection(node4, 4));
        node3.addConnection(new Connection(node5, 6));

        node5.setEndNode(true);
        
    }

    private void resetTestValues(){
        // Reset node values.
        node1.setCost(Float.POSITIVE_INFINITY);
        node2.setCost(Float.POSITIVE_INFINITY);
        node3.setCost(Float.POSITIVE_INFINITY);
        node4.setCost(Float.POSITIVE_INFINITY);
        node5.setCost(Float.POSITIVE_INFINITY);

        node1.setVisited(false);
        node2.setVisited(false);
        node3.setVisited(false);
        node4.setVisited(false);
        node5.setVisited(false);
    }
    
    public void testUpdateCosts(){

        resetTestValues();

        // Methods for this test.
        node1.setCost(0);
        node1.updateCosts();
        node1.setVisited(true);
        node2.updateCosts();
        node2.setVisited(true);

        // Test of de cost van node 3 gelijk is aan het theoretische voorbeeld met waarde 12.
        // Het getal 0.001 is de foutmarge voor deze test.
        assertEquals(12, node3.getCost(), 0.001);
    }

    public void testUpdateLowerCost(){

        resetTestValues();

        // Methods for this test.
        node1.setCost(0);
        node1.updateCosts();
        node1.setVisited(true);
        node2.updateCosts();
        node2.setVisited(true);
        node4.updateCosts();
        node4.setVisited(true);

        // Test of de cost van node 3 gelijk is aan het theoretische voorbeeld met waarde 10.
        // Het getal 0.001 is de foutmarge voor deze test.
        assertEquals(10, node3.getCost(), 0.001);
    }

    public void testUpdatePreviousNode(){

        resetTestValues();

        // Methods for this test.
        node1.setCost(0);
        node1.updateCosts();
        node1.setVisited(true);
        node2.updateCosts();
        node2.setVisited(true);

        // Test of de vorige node voor het korste pad klopt met het theoretische voorbeeld.
        assertEquals(node2, node3.getPreviousNode());
    }

    public void testUpdateNewPreviousNode(){

        resetTestValues();

        // Methods for this test.
        node1.setCost(0);
        node1.updateCosts();
        node1.setVisited(true);
        node2.updateCosts();
        node2.setVisited(true);
        node4.updateCosts();
        node4.setVisited(true);

        // Test of de vorige node voor het korste pad klopt met het theoretische voorbeeld.
        assertEquals(node4, node3.getPreviousNode());

    }


}