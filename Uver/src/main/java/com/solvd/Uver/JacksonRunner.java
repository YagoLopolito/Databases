package com.solvd.Uver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.SuperCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonRunner {
    private static final Logger l = LogManager.getLogger(JacksonRunner.class);

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        l.info("\n-------------------------CARS-------------------------");
        String carJSON = "{\"idCar\": 693, \"make\": \"Chevrolet\", \"model\": \"Sas 102\"}";
        try {
            Car car1 = mapper.readValue(carJSON, Car.class);
            l.info("\nCar 1 =" + "\nMake: " + car1.getMake() + "\nModel: " + car1.getModel() + "\nId: " + car1.getIdCar()
                    + "\n------------------------------------------------------\n");
        } catch (IOException e) {
            l.error("Car not found.");
        }

        SuperCar superCar = new SuperCar("FERRARI", "233", 1000);
        SuperCar superCar2 = new SuperCar("FERRARI", "venvenuto", 1540);

        List<SuperCar> superCars = new ArrayList<>();
        superCars.add(superCar);
        superCars.add(superCar2);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/json/superCars.json"), superCars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
