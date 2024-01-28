public class Fish {
    private String name;
    private double weight;
    private double price;

    public Fish(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " weight:" + this.weight + "price:" + this.price;
    }
}

