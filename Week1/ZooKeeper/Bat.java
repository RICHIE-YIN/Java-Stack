package ZooKeeper;

public class Bat extends Mammal implements Flyable, EatingHumans, Attack {
    

    public Bat() { //we need to create a constructor in order to set the energy level to 300
        // this.setEnergyLevel(300); //this works too
        super(300); //sets bat health to 300
        
        }

    @Override
    public void fly() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy -= 50);
        System.out.println("flup flup flup flup flup flup flup");
    }

    @Override
    public void eatHumans() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy += 25);
        System.out.println("IOUJGUIERGHVIUT YLGRHLOIESRUGHOIRE RIGHFEIULFGOIUVEHGUO ARGHGHHHHHHH");
    }

    @Override
    public void attackTown() {
        int currentEnergy = displayEnergyLevel();
        this.setEnergyLevel(currentEnergy -= 100);
        System.out.println("Auerg Auerg Auerg Auerg Auerg Auerg Auerg ");
    }
    }
