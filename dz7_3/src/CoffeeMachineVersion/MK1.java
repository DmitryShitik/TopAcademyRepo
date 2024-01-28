package CoffeeMachineVersion;

import Interface.Americano;
import Interface.Espresso;

public class MK1 extends CoffeeMachine implements Espresso, Americano {
    private int massCoffee;
    private int massWater;

    public MK1(String nameModel, double containerForGroundCoffee, double containerForWater, double containerFotWasteCoffee) {
        super(nameModel, containerForGroundCoffee, containerForWater, containerFotWasteCoffee);
    }

    @Override
    public void doEspresso() {
        massCoffee = 22;
        massWater = 30;
        System.out.println("cook espresso");
    }

    @Override
    public void doAmericano() {
        massCoffee = 22;
        massWater = 100;
        System.out.println("cook americano");
    }
}
