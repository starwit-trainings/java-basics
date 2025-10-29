package de.starwit;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Intro {
    static Logger log = LogManager.getLogger(Intro.class.getName());

    public static void main(String[] args) throws Exception {
        Car car_vw = new Car();
        car_vw.setManufacturer("Volkswagen");
        car_vw.setHorsePower(150);
        car_vw.setMaxSpeed(220);

        Car car_bmw = new Car();
        car_bmw.setManufacturer("BMW");
        car_bmw.setHorsePower(200);
        car_bmw.setMaxSpeed(240);

        Car car_dacia = new Car("Dacia", 180, 90);
        Car car_dacia_copy = car_dacia;
        
        Car super_dacia = new Car(car_dacia.getManufacturer(), car_dacia.getMaxSpeed(), 100);

        car_dacia.getHorsePower();
        test();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car_vw);
        cars.add(car_bmw);
        cars.add(car_dacia);

        for (Car car : cars) {
            log.info(car.toString());
        }

    }

    public static void test() {

    }


}
