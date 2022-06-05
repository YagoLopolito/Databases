package com.solvd.Uver;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Uver.entities.*;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.jdbcImpl.*;
import jakarta.xml.bind.JAXBContext;
import com.solvd.Uver.entities.OrderList;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.Uver.entities.Order;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;


public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws DAOException, IOException, JAXBException {
        Car car = new Car();
        Driver driver = new Driver();
        Moto moto = new Moto();
        SuperCar superCar = new SuperCar();
        SuperMotorcycle superMoto = new SuperMotorcycle();
        log.info("Do you want to use: \n1-JAXB\n2-MyBatis\n3-JDBC\n4-JSON");
        Scanner scannerOption = new Scanner(System.in);
        switch (scannerOption.nextInt()) {
            case 1:


                log.info("\nDo you want to:"
                        + "\n1- See the orders list."
                        + "\n2- ."
                        + "\n3- Update an objet."
                        + "\n4- Get all the objets of the table."
                        + "\n5- Get an objet by id.");
                Scanner scannerObject = new Scanner(System.in);

                switch (scannerObject.nextInt()) {

//                    JAXBContext context = JAXBContext.newInstance(OrderList.class);
//                    Unmarshaller unmarshaller = context.createUnmarshaller();
//                    OrderList orderList = (OrderList) unmarshaller.unmarshal(new File("src/main/resources/jaxb/Orders.xml"));
//                    log.info(orderList.getName() + "\n--------------------------------------------------------");
//
//                    ArrayList<Order> orders = orderList.getOrders();
//                    for (Order l : orders) {
//
//                        log.info("Order Id: " + l.getIdOrder() + "\nDistance: " + l.getDistance()
//                                + " Km\nEstimated time of arrival: " + l.getEstimatedTimeOfArrival()
//                                + " Minutes.\nDestination: " + l.getDestination()
//                                + "\nIs for transport: " + l.isDriver()
//                                + "\nIs for mailing: " + l.isMailing()
//                                + "\n--------------------------------------------------------");
        }

                break;
            case 2:
                Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                SqlSession session = sqlSessionFactory.openSession();
                car = session.selectOne("getById", 3);
                log.info("\n-------------CARS---------------\nCar Id: "
                        + car.getIdCar() + "\nMake: "
                        + car.getMake() + "\nModel: " + car.getModel()
                        + "\nMax Speed: " + car.getMaxSpeed());
                Car car2 = session.selectOne("getById", 1);
                log.info("\n---------------------------------\nCar Id: "
                        + car2.getIdCar() + "\nMake: "
                        + car2.getMake() + "\nModel: " + car2.getModel()
                        + "\nMax Speed: " + car2.getMaxSpeed());
                Car car3 = session.selectOne("getById", 5);
                log.info("\n--------------------------------\nCar Id: "
                        + car3.getIdCar() + "\nMake: "
                        + car3.getMake() + "\nModel: " + car3.getModel()
                        + "\nMax Speed: " + car3.getMaxSpeed()
                        + "\n--------------------------------\n");

                session.commit();
                session.close();

                break;
            case 3:
                log.info("\nDo you want to:"
                        + "\n1- Insert an objet in the database."
                        + "\n2- Delete an objet by id."
                        + "\n3- Update an objet."
                        + "\n4- Get all the objets of the table."
                        + "\n5- Get an objet by id.");
                Scanner scannerObject2 = new Scanner(System.in);

                switch (scannerObject2.nextInt()) {
                    case 1:

                        log.info("\nWhat objet do you want to insert:"
                                + "\n1-Car.\n2-Moto.\n3-Super Car.\n4-Super Moto.\n5-Driver.");
                        Scanner scannerInsert = new Scanner(System.in);

                        switch (scannerInsert.nextInt()) {
                            case 1:

                                CarServiceImplementation carS = new CarServiceImplementation();
                                Scanner scannerIdCar = new Scanner(System.in);
                                Scanner scannerMake = new Scanner(System.in);
                                Scanner scannerModel = new Scanner(System.in);

                                log.info("Introduce an id to the car.");
                                car.setIdCar(scannerIdCar.nextInt());

                                log.info("Introduce a make for the car.");
                                car.setMake(scannerMake.nextLine());

                                log.info("Introduce an model for the car.");
                                car.setModel(scannerModel.nextLine());

                                log.info("The car is going in, please wait...");
                                carS.insert(car);

                                log.info("The car was inserted in the database.");

                                break;
                            case 2:

                                MotorcycleServiceImplementation motoS = new MotorcycleServiceImplementation();
                                Scanner scannerIdMoto = new Scanner(System.in);
                                Scanner scannerMotoMake = new Scanner(System.in);
                                Scanner scannerMotoModel = new Scanner(System.in);

                                log.info("Introduce an id to the moto.");
                                moto.setIdCar(scannerIdMoto.nextInt());

                                log.info("Introduce a make for the moto.");
                                moto.setMake(scannerMotoMake.nextLine());

                                log.info("Introduce an model for the moto.");
                                moto.setModel(scannerMotoModel.nextLine());

                                log.info("The moto is going in, please wait...");
                                motoS.insert(moto);

                                log.info("The moto was inserted in the database.");

                                break;

                            case 3:
                                SuperCarServiceImplementation superCarS = new SuperCarServiceImplementation();
                                Scanner scannerIdSCar = new Scanner(System.in);
                                Scanner scannerSCarModel = new Scanner(System.in);

                                log.info("Introduce an id to the super car.");
                                superCar.setIdSuperCar(scannerIdSCar.nextInt());
                                superCar.setMake("Lamborghini");

                                log.info("Introduce an model for the Lamborghini.");
                                superCar.setModel(scannerSCarModel.nextLine());

                                log.info("The super car is going in, please wait...");
                                superCarS.insert(superCar);

                                log.info("The super car was inserted in the database.");
                                break;

                            case 4:
                                SuperMotoServiceImplementation superMotoS = new SuperMotoServiceImplementation();
                                Scanner scannerIdSuperMoto = new Scanner(System.in);
                                Scanner scannerSuperMotoModel = new Scanner(System.in);

                                log.info("Introduce an id to the car.");
                                superMoto.setIdSuperMotorcycle(scannerIdSuperMoto.nextInt());
                                superMoto.setMake("Harley Davinson");

                                log.info("Introduce an model for the Harley Davinson.");
                                superMoto.setModel(scannerSuperMotoModel.nextLine());

                                log.info("The super moto is going in, please wait...");
                                superMotoS.insert(superMoto);

                                log.info("The super moto was inserted in the database.");

                                break;
                            case 5:
                                DriverServiceImplementation driverS = new DriverServiceImplementation();
                                Scanner scannerIdDriver = new Scanner(System.in);
                                Scanner scannerFirstName = new Scanner(System.in);
                                Scanner scannerLastName = new Scanner(System.in);
                                Scanner scannerSex = new Scanner(System.in);

                                log.info("Introduce an id to the driver.");
                                driver.setIdDriver(scannerIdDriver.nextInt());

                                log.info("Introduce a the first name of the driver.");
                                driver.setFirstName(scannerFirstName.nextLine());

                                log.info("Introduce a the last name of the driver.");
                                driver.setLastName(scannerLastName.nextLine());

                                log.info("Introduce the sex of the driver, M or F.");
                                driver.setSex(scannerSex.nextLine());

                                log.info("The driver is going in, please wait...");
                                driverS.insert(driver);

                                log.info("The driver was inserted in the database.");

                                break;
                        }

                        break;

                    case 2:

                        log.info("\nWhat objet do you want to delete from the database:"
                                + "\n1-Car.\n2-Moto.\n3-Super Car.\n4-Super Moto.\n5-Driver.");
                        Scanner scannerDelete = new Scanner(System.in);

                        switch (scannerDelete.nextInt()) {
                            case 1:

                                CarServiceImplementation carS = new CarServiceImplementation();
                                Scanner scannerDeleteCar = new Scanner(System.in);
                                int id = 0;

                                log.info("Select the id number of the car that you want to delete.");
                                id = scannerDeleteCar.nextInt();

                                log.info("The car is being removed from the database, please wait...");
                                carS.deleteById(id);

                                log.info("The car was removed.");

                                break;

                            case 2:

                                MotorcycleServiceImplementation motoS = new MotorcycleServiceImplementation();
                                Scanner scannerDeleteMoto = new Scanner(System.in);

                                log.info("Select the id number of the moto that you want to delete.");
                                id = scannerDeleteMoto.nextInt();

                                log.info("The moto is being removed from the database, please wait...");
                                motoS.deleteById(id);

                                log.info("The moto was removed.");

                                break;

                            case 3:

                                SuperCarServiceImplementation superCarS = new SuperCarServiceImplementation();
                                Scanner scannerDeleteSuperCar = new Scanner(System.in);
                                log.info("Select the id number of the super car that you want to delete.");
                                id = scannerDeleteSuperCar.nextInt();

                                log.info("The super car is being removed from the database, please wait...");
                                superCarS.deleteById(id);

                                log.info("The super car was removed.");

                                break;

                            case 4:

                                SuperMotoServiceImplementation superMotoS = new SuperMotoServiceImplementation();
                                Scanner scannerDeleteSuperMoto = new Scanner(System.in);
                                log.info("Select the id number of the super moto that you want to delete.");
                                id = scannerDeleteSuperMoto.nextInt();

                                log.info("The super moto is being removed from the database, please wait...");
                                superMotoS.deleteById(id);

                                log.info("The super moto was removed.");

                                break;

                            case 5:

                                DriverServiceImplementation driverS = new DriverServiceImplementation();
                                Scanner scannerDeleteDriver = new Scanner(System.in);

                                log.info("Select the id number of the driver that you want to delete.");
                                id = scannerDeleteDriver.nextInt();

                                log.info("The driver is being removed from the database, please wait...");
                                driverS.deleteById(id);

                                log.info("The driver was removed.");

                                break;
                        }

                        break;

                    case 3:
                        log.info("\nWhat objet do you want to update from the database:"
                                + "\n1-Car.\n2-Moto.\n3-Super Car.\n4-Super Moto.\n5-Driver.");
                        Scanner scannerUpdate = new Scanner(System.in);

                        switch (scannerUpdate.nextInt()) {

                            case 1:
                                CarServiceImplementation carS = new CarServiceImplementation();
                                Scanner scannerIdCar = new Scanner(System.in);
                                Scanner scannerMake = new Scanner(System.in);
                                Scanner scannerModel = new Scanner(System.in);

                                log.info("Introduce an id of the car you want update.");
                                car.setIdCar(scannerIdCar.nextInt());
                                int id = 0;
                                id = car.getIdCar();

                                log.info("You are updating the car: " + carS.getById(id));

                                log.info("Introduce a make to update for the car N°: "
                                        + car.getIdCar());
                                car.setMake(scannerMake.nextLine());

                                log.info("Introduce an model to update for the car N°: "
                                        + car.getIdCar());
                                car.setModel(scannerModel.nextLine());

                                log.info("The car is being updated, please wait...");
                                carS.update(car);

                                log.info("The car was updated in the in the database.");

                                break;
                            case 2:
                                MotorcycleServiceImplementation motoS = new MotorcycleServiceImplementation();
                                Scanner scannerIdMoto = new Scanner(System.in);
                                Scanner scannerMotoMake = new Scanner(System.in);
                                Scanner scannerMotoModel = new Scanner(System.in);
                                log.info("Introduce an id of the moto you want update.");
                                moto.setIdCar(scannerIdMoto.nextInt());

                                id = moto.getIdCar();
                                log.info("You are updating the moto: " + motoS.getById(id));

                                log.info("Introduce a make to update for the moto N°: " + moto.getIdCar());
                                moto.setMake(scannerMotoMake.nextLine());

                                log.info("Introduce an model to update for the moto N°: " + moto.getIdCar());
                                moto.setModel(scannerMotoModel.nextLine());

                                log.info("The moto is being updated, please wait...");
                                motoS.update(moto);

                                log.info("The moto was updated in the in the database.");
                                break;
                            case 3:
                                SuperCarServiceImplementation superCarS = new SuperCarServiceImplementation();
                                Scanner scannerIdSuperCar = new Scanner(System.in);
                                Scanner scannerSuperCarMake = new Scanner(System.in);
                                Scanner scannerSuperCarModel = new Scanner(System.in);

                                log.info("Introduce an id of the super car you want update.");
                                superCar.setIdSuperCar(scannerIdSuperCar.nextInt());
                                id = superCar.getIdSuperCar();
                                log.info("You are updating the driver: " + superCarS.getById(id));

                                log.info("Introduce a make to update for the super car N°: ."
                                        + superCar.getIdSuperCar());
                                superCar.setMake(scannerSuperCarMake.nextLine());

                                log.info("Introduce an model to update for the super car N°: ."
                                        + superCar.getIdSuperCar());
                                superCar.setModel(scannerSuperCarModel.nextLine());

                                log.info("the super car is being updated, please wait...");
                                superCarS.update(superCar);

                                log.info("The super car was updated in the in the database.");

                                break;

                            case 4:
                                SuperMotoServiceImplementation superMotoS = new SuperMotoServiceImplementation();
                                Scanner scannerIdSuperMoto = new Scanner(System.in);
                                Scanner scannerMotoSuperMotoMake = new Scanner(System.in);
                                Scanner scannerMotoSuperMotoModel = new Scanner(System.in);

                                log.info("Introduce an id of the Super Moto you want update.");
                                superMoto.setIdSuperMotorcycle(scannerIdSuperMoto.nextInt());
                                id = superMoto.getIdSuperMotorcycle();

                                log.info("You are updating the driver: " + superMotoS.getById(id));

                                log.info("Introduce a make to update for the Super Moto N°: "
                                        + superMoto.getIdSuperMotorcycle());
                                superMoto.setMake(scannerMotoSuperMotoMake.nextLine());

                                log.info("Introduce an model to update for the Super Moto N°: "
                                        + superMoto.getIdSuperMotorcycle());
                                superMoto.setModel(scannerMotoSuperMotoModel.nextLine());

                                log.info("The Super Moto is being updated, please wait...");
                                superMotoS.update(superMoto);

                                log.info("The Super Moto was updated in the in the database.");

                                break;

                            case 5:
                                DriverServiceImplementation driverS = new DriverServiceImplementation();
                                Scanner scannerIdDriver = new Scanner(System.in);
                                Scanner scannerFirstName = new Scanner(System.in);
                                Scanner scannerLastName = new Scanner(System.in);
                                Scanner scannerWage = new Scanner(System.in);

                                log.info("Introduce an id of the driver you want update.");
                                driver.setIdDriver(scannerIdDriver.nextInt());
                                id = driver.getIdDriver();
                                log.info("You are updating the driver: " + driverS.getById(id));
                                log.info("Introduce a first name to update for the driver N°: ."
                                        + driver.getIdDriver());
                                driver.setFirstName(scannerFirstName.nextLine());

                                log.info("Introduce a last name to update for the driver N°: ."
                                        + driver.getIdDriver());
                                driver.setLastName(scannerLastName.nextLine());

                                log.info("Introduce the wage to update for the driver.");
                                driver.setWage(scannerWage.nextInt());

                                log.info("the driver is being updated, please wait...");
                                driverS.update(driver);

                                log.info("The driver was updated in the in the database.");

                                break;

                        }

                        break;

                    case 4:

                        log.info("\nWhat complete table want to see:"
                                + "\n1-Car.\n2-Moto.\n3-Super Car.\n4-Super Moto.\n5-Driver.");
                        Scanner scannerGetAll = new Scanner(System.in);

                        switch (scannerGetAll.nextInt()) {

                            case 1:

                                CarServiceImplementation carS = new CarServiceImplementation();
                                log.info("The list of cars is as follows.\n" + carS.getAll());

                                break;
                            case 2:

                                MotorcycleServiceImplementation motoS = new MotorcycleServiceImplementation();
                                log.info("The list of motos is as follows.\n" + motoS.getAll());

                                break;

                            case 3:

                                SuperCarServiceImplementation superCarS = new SuperCarServiceImplementation();
                                log.info("The list of super cars is as follows...\n" + superCarS.getAll());

                                break;

                            case 4:

                                SuperMotoServiceImplementation superMotoS = new SuperMotoServiceImplementation();
                                log.info("The list of super motos is as follows...\n" + superMotoS.getAll());

                                break;

                            case 5:
                                DriverServiceImplementation driverS = new DriverServiceImplementation();
                                log.info("The list of drivers is as follows...\n" + driverS.getAll());

                                break;

                        }

                        break;

                    case 5:

                        log.info("\nWhat objet do you want to see from the database:"
                                + "\n1-Car.\n2-Moto.\n3-Super Car.\n4-Super Moto.\n5-Driver.");
                        Scanner scannerGetById = new Scanner(System.in);

                        switch (scannerGetById.nextInt()) {

                            case 1:

                                CarServiceImplementation carS = new CarServiceImplementation();
                                Scanner scannerGetByIdCar = new Scanner(System.in);
                                log.info("Enter the id of the car you want to see from the database: ");
                                int id = 0;
                                id = scannerGetByIdCar.nextInt();
                                car.setIdCar(id);
                                log.info("The car is as follows...\n" + carS.getById(id));

                                break;
                            case 2:

                                MotorcycleServiceImplementation motoS = new MotorcycleServiceImplementation();
                                Scanner scannerGetByIdMoto = new Scanner(System.in);
                                log.info("Enter the id of the moto you want to see from the database: ");
                                id = scannerGetByIdMoto.nextInt();
                                moto.setIdCar(id);
                                log.info("The moto is as follows...\n" + motoS.getById(id));

                                break;

                            case 3:

                                SuperCarServiceImplementation superCarS = new SuperCarServiceImplementation();
                                Scanner scannerGetByIdSuperCar = new Scanner(System.in);
                                log.info("Enter the id of the super car you want to see from the database: ");
                                id = scannerGetByIdSuperCar.nextInt();
                                superCar.setIdSuperCar(id);
                                log.info("The super car is as follows...\n" + superCarS.getById(id));
                                break;

                            case 4:

                                SuperMotoServiceImplementation superMotoS = new SuperMotoServiceImplementation();
                                Scanner scannerGetByIdSuperMoto = new Scanner(System.in);
                                log.info("Enter the id of the super moto you want to see from the database: ");
                                id = scannerGetByIdSuperMoto.nextInt();
                                superMoto.setIdSuperMotorcycle(id);
                                log.info("The super moto is as follows...\n" + superMotoS.getById(id));

                                break;

                            case 5:
                                DriverServiceImplementation driverS = new DriverServiceImplementation();
                                Scanner scannerGetByIdDriver = new Scanner(System.in);
                                log.info("Enter the id of the driver you want to see from the database: ");
                                id = scannerGetByIdDriver.nextInt();
                                driver.setIdDriver(id);
                                log.info("The super moto is as follows...\n" + driverS.getById(id));
                                break;

                        }

                        break;

                }

                break;
            case 4:
                ObjectMapper mapper = new ObjectMapper();

                log.info("\nDo you want to:"
                        + "\n1- Write a list of super cars in JSON."
                        + "\n2- Read a the list of super cars in JSON."
                        + "\n3- Write a list of cars."
                        + "\n4- Read the list of cars.");
                Scanner scannerObject3 = new Scanner(System.in);

                switch (scannerObject3.nextInt()) {
                    case 1:
                        int cant = 0;
                        Scanner scannerCant = new Scanner(System.in);
                        log.info("\nHow many super cars do you want to add?");
                        cant = scannerCant.nextInt() - 1;
                        List<SuperCar> superCars = new ArrayList<>();
                        for (int i = 0; i <= cant; i = i + 1) {
                            SuperCar superCarJSON = new SuperCar();
                            Scanner scannerMakeSuperCarJSON = new Scanner(System.in);
                            Scanner scannerModelSuperCarJSON = new Scanner(System.in);
                            Scanner scannerMaxSpeedSuperCarJSON = new Scanner(System.in);

                            log.info("\nWrite the car make.");
                            superCarJSON.setMake(scannerMakeSuperCarJSON.nextLine());

                            log.info("\nWrite the car model.");
                            superCarJSON.setModel(scannerModelSuperCarJSON.nextLine());

                            log.info("\nWrite the car max speed.");
                            superCarJSON.setMaxSpeed(scannerMaxSpeedSuperCarJSON.nextInt());


                            superCars.add(superCarJSON);
                        }
                        try {
                            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/json/superCars.json"), superCars);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        break;

                    case 2:

                        File file = new File("src/main/resources/json/superCars.json");

                        try {
                           SuperCar sCar1 = mapper.readValue(file, SuperCar.class);
                            log.info(sCar1);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 3:

                        Scanner scannerCant2 = new Scanner(System.in);
                        log.info("\nHow many cars do you want to add?");
                        cant = scannerCant2.nextInt() - 1;
                        List<Car> cars = new ArrayList<>();
                        for (int i = 0; i <= cant; i = i + 1) {
                            Car CarJSON = new Car();
                            Scanner scannerMakeCarJSON = new Scanner(System.in);
                            Scanner scannerModelCarJSON = new Scanner(System.in);
                            Scanner scannerMaxSpeedCarJSON = new Scanner(System.in);

                            log.info("\nWrite the car make.");
                            CarJSON.setMake(scannerMakeCarJSON.nextLine());

                            log.info("\nWrite the car model.");
                            CarJSON.setModel(scannerModelCarJSON.nextLine());

                            log.info("\nWrite the car max speed.");
                            CarJSON.setMaxSpeed(scannerMaxSpeedCarJSON.nextInt());


                            cars.add(CarJSON);
                        }
                        try {
                            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/json/car.json"), cars);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        File file2 = new File("src/main/resources/json/car.json");

                        try {
                            Car car1 = mapper.readValue(file2, Car.class);
                            log.info(car1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                }


        }
    }
}



