package com.solvd.Uver.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CarListJSON {
    public static List<Car> getCars(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(
                    List.class, Car.class);
            return objectMapper.readValue(inputStream, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
