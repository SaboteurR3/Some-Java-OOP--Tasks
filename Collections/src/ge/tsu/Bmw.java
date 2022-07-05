package ge.tsu;

public class Bmw extends Car {
    String model;

    public Bmw(String model, float speed, float weight) {
        super(speed, weight);
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "{" +
                "speed=" + speed +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }
}