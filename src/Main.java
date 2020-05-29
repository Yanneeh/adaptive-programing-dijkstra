package src;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        network.setupDefaultNetwork();

        Route route = network.travelNetwork(1, 5);

        System.out.println(String.format("De route is %f lang", route.getCost()));

    }
}