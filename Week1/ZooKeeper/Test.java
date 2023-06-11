package ZooKeeper;

public class Test {
    
    public static void main(String[] args) {
        // Gorilla gorillaTest = new Gorilla(100); //have to pass in 100 for the energy level
        // gorillaTest.throwSomething();
        // gorillaTest.throwSomething();
        // gorillaTest.throwSomething();
        // gorillaTest.eatBanana();
        // gorillaTest.eatBanana();
        // gorillaTest.climb();
        // System.out.println(gorillaTest.displayEnergyLevel());
        Bat batTest = new Bat();
        batTest.attackTown();
        batTest.attackTown();
        batTest.attackTown();
        batTest.eatHumans();
        batTest.eatHumans();
        batTest.fly();
        batTest.fly();
        System.out.println(batTest.displayEnergyLevel());
    }
}
