package de.starwit;

public class Car {
    private String manufacturer;
    private double maxSpeed;
    private double horsePower;

    public Car() {}

    public Car(String manufacturer, double maxSpeed, double horsePower) {
        this.setManufacturer(manufacturer);
        this.setMaxSpeed(maxSpeed);
        this.setHorsePower(horsePower);
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer.length() == 0) {
            throw new IllegalArgumentException("manufacturer must be non-empty");
        }
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setMaxSpeed(double maxSpeed) {
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("maxSpeed must be greater than 0");
        }
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setHorsePower(double horsePower) {
        if (horsePower <= 0) {
            throw new IllegalArgumentException("horsePower must be greater than 0");
        }
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return this.horsePower;
    }

    public String toString() {
        return "Car(manufacturer=" + this.manufacturer + ", maxSpeed=" + this.maxSpeed + ", horsePower=" + this.horsePower + ")";
    }
}