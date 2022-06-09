package com.solvd.Uver.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.solvd.Uver.service.mybatis.AbstractService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CarListJSON {
    private static final Logger log = LogManager.getLogger(CarListJSON.class);
    public static List<Car> getCars(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(
                    List.class, Car.class);
            return objectMapper.readValue(inputStream, collectionType);
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }
}
