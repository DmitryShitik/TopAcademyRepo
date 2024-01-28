package CoffeeMachineVersion;

import Interface.Americano;
import Interface.Cappuccino;
import Interface.Espresso;
import Interface.Late;

public class MK2 extends CoffeeMachine implements Americano, Espresso, Late, Cappuccino {
    private double containerMilk;

    public MK2(String nameModel,
               double containerForGroundCoffee,
               double containerForWater,
               double containerFotWasteCoffee,
               double containerMilk) {
        super(nameModel, containerForGroundCoffee, containerForWater, containerFotWasteCoffee);
        this.containerMilk = containerMilk;
    }

    public void setContainerMilk(double containerMilk) {
        this.containerMilk = containerMilk;
    }

    @Override
    public void doAmericano() {
        System.out.println("Chose milk count");
        System.out.println("cook americano");
    }

    @Override
    public void doEspresso() {
        System.out.println("cook espresso");
    }

    @Override
    public void doLate() {
        System.out.println("Chose milk count");
        System.out.println("cook late");
    }

    @Override
    public void doCappuccino() {
        System.out.println("Chose milk count");
        System.out.println("cook cappuccino");
    }

    public void containerMilkIsEmptyException() {
        System.out.println("container milk is empty");
    }
}
