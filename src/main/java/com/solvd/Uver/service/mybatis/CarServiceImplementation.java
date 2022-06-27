package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.CarService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class CarServiceImplementation extends AbstractService implements CarService {
    private final static Logger log = LogManager.getLogger(CarServiceImplementation.class);


    @Override
    public void insert(Car a) throws MyBatisException, ConnectException {
        CarDAO carDAO;
        try (SqlSession session = sqlSession()) {
            carDAO = session.getMapper(CarDAO.class);
            carDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Car a) throws MyBatisException, ConnectException {
        CarDAO carDAO;
        try (SqlSession session = sqlSession()) {
            carDAO = session.getMapper(CarDAO.class);
            carDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws MyBatisException, ConnectException {
        CarDAO carDAO;
        try (SqlSession session = sqlSession()) {
            carDAO = session.getMapper(CarDAO.class);
            carDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public Car getById(int id) throws MyBatisException, ConnectException {
        CarDAO carDAO;
        Car a;
        try (SqlSession session = sqlSession()) {
            carDAO = sqlSession().getMapper(CarDAO.class);
            a = carDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<Car> getAll() throws MyBatisException, ConnectException {
        CarDAO carDAO;
        List<Car> carList;
        try (SqlSession session = sqlSession()) {
            carDAO = sqlSession().getMapper(CarDAO.class);
            carList = carDAO.getAll();
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);

        }
        return carList;
    }
}
