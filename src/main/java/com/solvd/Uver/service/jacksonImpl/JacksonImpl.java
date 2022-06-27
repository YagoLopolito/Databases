package com.solvd.Uver.service.jacksonImpl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.SuperCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonImpl {
    private static final Logger log = LogManager.getLogger(JacksonImpl.class);
    ObjectMapper mapper = new ObjectMapper();

    public List<SuperCar> unmarshallSuperCar() {

        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, SuperCar.class);
            List<SuperCar> superCars = mapper.readValue(new File("src/main/resources/json/superCars.json"), type);
            return superCars;
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }

    public void marshallSuperCar(List<SuperCar> inventory) {
        File file = new File("src/main/resources/json/superCars.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.writeValue(file, inventory);
        } catch (IOException e) {
            log.error(e);
        }
    }

    public List<Car> unmarshallCar() {

        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Car.class);
            List<Car> cars = mapper.readValue(new File("src/main/resources/json/car.json"), type);
            return cars;
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }

    public void marshallCar(List<Car> cars) {
        File file = new File("src/main/resources/json/car.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.writeValue(file, cars);
        } catch (IOException e) {
            log.error(e);
        }
    }
}

