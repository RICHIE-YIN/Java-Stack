package ZooKeeper;

public class Gorilla extends Mammal {

    //optional. gets the super from Mammal and allows ypou to set energy here
    public Gorilla(int energyLevel) {
        super(energyLevel);
    }


    public void throwSomething() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy -= 5);
        System.out.println("The gorilla threw something");
    }

    public void eatBanana() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy += 10);
        System.out.println("The gorilla just ate!");
    }

    public void climb() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy -= 10);
        System.out.println("The gorilla is climbing!");
    }
}
