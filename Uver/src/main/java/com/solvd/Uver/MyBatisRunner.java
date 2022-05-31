package com.solvd.Uver;

import com.solvd.Uver.daos.*;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.DeliveryMan;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.entities.Order;
import com.solvd.Uver.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class MyBatisRunner {
    private static final Logger l = LogManager.getLogger(MyBatisRunner.class);

    private static final SqlSessionFactory factory = SqlSessionFactoryUtil.getInstance();

    public static void main(String[] args) throws Exception {

        try (SqlSession session = factory.openSession()) {
            l.info("\nCARS\n");
            CarDAO carMapper = session.getMapper(CarDAO.class);
            Car car = carMapper.give(2);
            l.info("Car = " + car);
            carMapper.insert(car);
            carMapper.modify(car);
            l.info("Plane = " + carMapper.give(2));
            List<Car> cars = carMapper.giveAll();
            cars.forEach((p) -> {
                l.info(p);
            });

            l.info("\nCLIENTS\n");
            ClientDAO clientMapper = session.getMapper(ClientDAO.class);
            l.info("Client = " + clientMapper.give(1));

            l.info("\nDELIVERY MAN\n");
            DeliveryManDAO deliveryManMapper = session.getMapper(DeliveryManDAO.class);
            DeliveryMan deliveryMan = deliveryManMapper.give(1);
            l.info("Delivery Man = " + deliveryMan);

            l.info("\nMOTORCYCLE\n");
            MotorcycleDAO motorcycleMapper = session.getMapper(MotorcycleDAO.class);
            Moto moto = motorcycleMapper.give(2);
            l.info("Motorcycle = " + moto);

            l.info("\nSUPER CAR\n");
            SuperCarDAO superCarMapper = session.getMapper(SuperCarDAO.class);
            l.info("Super Car = " + superCarMapper.give(1));
            l.info("Super Cars = " + superCarMapper.giveAll());

            l.info("\nSUPER MOTORCYCLE\n");
            SuperMotoDAO superMotoMapper = session.getMapper(SuperMotoDAO.class);
            l.info("Super Motorcycle = " + superMotoMapper.give(1));
            l.info("Super Motorcycle = " + superMotoMapper.giveAll());

        }
    }
}