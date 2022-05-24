package com.solvd.Uver.model.Util;

import com.solvd.Uver.model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private static final Logger l = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws JAXBException {
        SuperMotorcycle superMotorcycle = new SuperMotorcycle(1, 300, "Yamaha", "R1");
        SuperCar superCar = new SuperCar(1,350, "Lamborghini", "Sesto Elemento");
        Car car = new Car(1, 174, "Chevrolet", "Corsa");
        Moto moto = new Moto(1, 100, "Zanella", "Due Classic");
        Client client = new Client();

        Scanner scannerName = new Scanner(System.in);
        l.info("\nEnter your first name: ");
        client.setFirstName(scannerName.nextLine());

        Scanner scannerLastName = new Scanner(System.in);
        l.info("\nEnter your last name: ");
        client.setLastName(scannerLastName.nextLine());
        l.info("\n¡Hello "+client.getFirstName()+" "+client.getLastName()
                +"!\nYou want a deliver or a transport?\nPress 1 to deliver, 2 to transport.");
        Scanner scannerOption = new Scanner(System.in);

        switch (scannerOption.nextInt()){
            case 1:
                l.info("\nDo you want a premium service? \n1 to yes, 2 to no.");
                switch (scannerOption.nextInt()){
                    case 1:
                        l.info("\nWe are going to assign you a premium motorcycle"
                                +"\nThe motorcycle is a " + superMotorcycle.getMake()
                                +" "+ superMotorcycle.getModel()+".");
                        break;
                    case 2:
                        l.info("\nWe are going to assign you a motorcycle to deliver you the product."
                                +"\nThe motorcycle is a " + moto.getMake()
                                +" "+ moto.getModel()+".");
                        break;

                }
                break;

            case 2:
                l.info("\nDo you want a premium service? \n 1 to yes, 2 to no.");
                switch (scannerOption.nextInt()){
                    case 1:
                    l.info("\nWe are going to assign you a premium car to transport you."
                            +"\nThe car is a " + superCar.getMake()
                            +" "+ superCar.getModel()+".");
                        break;
                    case 2:
                        l.info("\nWe are going to assign you a  car to transport you."
                                +"\nThe car is a " + car.getMake()
                                +" "+ car.getModel()+".");
                        break;
                }
                break;
        }

      JAXBContext context = JAXBContext.newInstance(OrderList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrderList orderList = (OrderList) unmarshaller.unmarshal(new File("src/main/resources/Orders.xml"));
        System.out.println(orderList.getName()+"\n--------------------------------------------------------");

        ArrayList<Order> orders = orderList.getOrders();
        for (Order l:orders) {

            System.out.println("Order Id: " + l.getIdOrder() + "\nDistance: " + l.getDistance()
                    + " Km\nEstimated time of arrival: " + l.getEstimatedTimeOfArrival()
                    + " Minutes.\nDestination: " + l.getDestination()
                    + "\nIs for transport: " + l.isDriver()
                    + "\nIs for mailing: " + l.isMailing()
                    + "\n--------------------------------------------------------");
        }
    }
}