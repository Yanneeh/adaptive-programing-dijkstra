package tests;

import src.*;

import static org.junit.Assert.assertEquals;

public class TestNetwork {
    
    Network network;

    public void setupTest(){
        network = new Network();

        network.setupDefaultNetwork();
    }

    public void testRoute(){
        //assertEquals(expected, network.travelNetwork(1, 5));
    }
}