package CoffeeMachineVersion;

public abstract class CoffeeMachine {
    private String nameModel;
    private double containerForGroundCoffee;
    private double containerForWater;
    private double containerFotWasteCoffee;

    public void setContainerForGroundCoffee(double containerForGroundCoffee) {
        this.containerForGroundCoffee = containerForGroundCoffee;
    }

    public void setContainerForWater(double containerForWater) {
        this.containerForWater = containerForWater;
    }

    public CoffeeMachine(String nameModel, double containerForGroundCoffee, double containerForWater, double containerFotWasteCoffee) {
        this.nameModel = nameModel;
        this.containerForGroundCoffee = containerForGroundCoffee;
        this.containerForWater = containerForWater;
        this.containerFotWasteCoffee = containerFotWasteCoffee;
    }

    public void buttonOn() {
        System.out.println("On");
    }

    public void ButtonOff() {
        System.out.println("Off");
    }

    public void clearContainerWasterCoffee() {
        System.out.println("Container is clear");
    }

    public void containerWaterIsEmptyException() {
        System.out.println("Water is out");
    }

    public void containerGroundCoffeeIsEmptyException() {
        System.out.println("Ground coffee is out");
    }

    public void containerWasteCoffeeIsFull() {
        System.out.println("container waste coffee is full");
    }

}
