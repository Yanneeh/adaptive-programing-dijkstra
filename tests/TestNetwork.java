package tests;

import src.*;

import static org.junit.Assert.assertEquals;

public class TestNetwork {
    
    Network network;

    public void setupTest(){
        network = new Network();

        network.setupDefaultNetwork();
    }

    public void testUnreachableStartPoint(){
        assertEquals(null, network.travelNetwork(10, 5));
    }

    public void testUnreachableEndPoint(){
        assertEquals(null, network.travelNetwork(1, 10));
    }

    public void testEndPointEqualsBeginPoint(){
        assertEquals(null, network.travelNetwork(1, 1));
    }

    public void testRoute(){

        Route route = network.travelNetwork(1, 5);

        assertEquals(1, route.getNode(0).getId());
        assertEquals(4, route.getNode(1).getId()); 
        
    }
}