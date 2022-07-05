package ge.tsu;

public class Porsche extends Car {
    String model;
    public Porsche(String model, float speed, float wieght) {
        super(speed, wieght);
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
