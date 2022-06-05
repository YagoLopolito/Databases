package com.solvd.Uver.service;

import com.solvd.Uver.Runner;
import com.solvd.Uver.entities.Order;
import com.solvd.Uver.entities.OrderList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

public class JAXBRunner {
    private static final Logger log = LogManager.getLogger(Runner.class);
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(OrderList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrderList orderList = (OrderList) unmarshaller.unmarshal(new File("src/main/resources/jaxb/Orders.xml"));
        log.info(orderList.getName() + "\n--------------------------------------------------------");

        ArrayList<Order> orders = orderList.getOrders();
        for (Order l : orders) {

            log.info("Order Id: " + l.getIdOrder() + "\nDistance: " + l.getDistance()
                    + " Km\nEstimated time of arrival: " + l.getEstimatedTimeOfArrival()
                    + " Minutes.\nDestination: " + l.getDestination()
                    + "\nIs for transport: " + l.isDriver()
                    + "\nIs for mailing: " + l.isMailing()
                    + "\n--------------------------------------------------------");
        }
    }
}