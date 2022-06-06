package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.CarService;
import com.solvd.Uver.util.Constants;
import com.solvd.Uver.util.DBPropertiesUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarServiceMyBatisImpl implements CarService {
    private final static Logger log = LogManager.getLogger(CarServiceMyBatisImpl.class);
    private final static String MYBATIS = DBPropertiesUtil.getString(Constants.MYBATIS);

    @Override
    public void insert(Car a) {
        CarDAO carDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            carDAO = session.getMapper(CarDAO.class);
            carDAO.insert(a);
            session.commit();
        } catch (IOException | DAOException e ) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Car a) throws ConnectException {
        CarDAO carDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            carDAO = session.getMapper(CarDAO.class);
            carDAO.update(a);
            session.commit();
        } catch (IOException  | DAOException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws ConnectException {
        CarDAO carDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            carDAO = session.getMapper(CarDAO.class);
            carDAO.deleteById(id);
            session.commit();
        } catch (IOException  | DAOException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public Car getById(int id) throws ConnectException {
        CarDAO carDAO;
        Car a;
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            carDAO = sqlSessionFactory.openSession().getMapper(CarDAO.class);
            a = carDAO.getById(id);
        } catch (IOException | DAOException e) {
            log.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }
    @Override
    public List<Car> getAll() throws ConnectException {
        CarDAO carDAO;
        List<Car> carList;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            carList = new ArrayList<>();
            carDAO = sqlSessionFactory.openSession().getMapper(CarDAO.class);
            carList = carDAO.getAll();

        } catch (IOException | DAOException e ) {
            log.info("MyBatis error." + e);
            throw new RuntimeException(e);
        };
        return carList;
    }
}
