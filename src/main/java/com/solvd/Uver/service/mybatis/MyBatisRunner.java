package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.Runner;
import com.solvd.Uver.entities.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisRunner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Car car = session.selectOne("getById", 3);
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
    }
}



