package tests;

public class TestRunner {
    public static void main(String[] args) {
        TestNode test = new TestNode();
        test.setupTest();
        test.testUpdateCosts();
        test.testUpdateLowerCost();
        test.testUpdatePreviousNode();
        test.testUpdateNewPreviousNode();

        TestNetwork testNetwork = new TestNetwork();

        testNetwork.setupTest();
    }
}