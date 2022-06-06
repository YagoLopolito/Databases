package com.solvd.Uver.service.jaxbImpl;

import com.solvd.Uver.entities.OrderList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class JaxBImpl {
    public List<OrderList> unmarshallOrderList() {

        {

            try {
                File file = new File("src/main/resources/jaxb/Orders.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                OrderList orderList = (OrderList) unmarshaller.unmarshal(file);
                return null;
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void setOrderList(OrderList orderList){

        try {
            File file = new File("src/main/resources/jaxb/Orders.xml");
            JAXBContext jaxbContext =JAXBContext.newInstance(OrderList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(orderList, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

