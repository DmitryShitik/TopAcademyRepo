package CoffeeMachineVersion;

import Interface.Americano;
import Interface.Late;

public class MK3 extends CoffeeMachine implements Americano, Late {
    private double containerForCoffeeSeeds;

    public MK3(String nameModel, double containerForGroundCoffee, double containerForWater, double containerFotWasteCoffee) {
        super(nameModel, containerForGroundCoffee, containerForWater, containerFotWasteCoffee);
    }

    private void grindCoffeeSeeds(){
        System.out.println("Grind seeds");
    }
    public void containerCoffeeSeedsIsEmpty(){
        System.out.println("Container coffee seeds is empty");
    }
    @Override
    public void doAmericano() {
        System.out.println("cook americano");
    }

    @Override
    public void doLate() {
        System.out.println("Chose milk count");
        System.out.println("cook late");
    }
}
