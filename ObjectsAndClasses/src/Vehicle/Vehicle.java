package Vehicle;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return model;
    }

    public void setType(String type) {
        type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
        this.type = type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String toString(){
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", type, model,color,horsepower);
    }
}
