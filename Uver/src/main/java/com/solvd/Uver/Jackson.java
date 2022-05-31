package com.solvd.Uver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Uver.entities.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Jackson {
    private static final Logger l = LogManager.getLogger(Jackson.class);

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        l.info("\n-------------------------CARS-------------------------\n");
        String carJSON = "{\"idCar\": 693, \"make\": \"Chevrolet\", \"model\": \"Sas 102\"}";
        try {
            Car car1 = mapper.readValue(carJSON, Car.class);
            l.info("\nMake: " + car1.getMake() + "\nModel: " + car1.getModel() + "\nId: " + car1.getIdCar());
        } catch (IOException e) {
            l.error("Car not found.");
        }
    }
}
