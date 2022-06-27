package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.DriverDAO;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.DriverService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class DriverServiceImplementation extends AbstractService implements DriverService {
    private final static Logger log = LogManager.getLogger(DriverServiceImplementation.class);

    @Override
    public void insert(Driver a) throws MyBatisException, ConnectException {
        DriverDAO driverDAO;
        try (SqlSession session = sqlSession()) {
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis Error." + e);
        }
    }

    @Override
    public void update(Driver a) throws MyBatisException, ConnectException {
        DriverDAO driverDAO;
        try (SqlSession session = sqlSession()) {
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis error." + e);
        }
    }

    @Override
    public void deleteById(int id) throws MyBatisException, ConnectException {
        DriverDAO driverDAO;
        try (SqlSession session = sqlSession()) {
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("Error in MyBatis." + e);
        }
    }

    @Override
    public Driver getById(int id) throws MyBatisException, ConnectException {
        DriverDAO driverDAO;
        Driver a;
        try (SqlSession session = sqlSession()) {
            driverDAO = sqlSession().getMapper(DriverDAO.class);
            a = driverDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<Driver> getAll() throws MyBatisException, ConnectException {
        DriverDAO driverDAO;
        List<Driver> drivers;
        try (SqlSession session = sqlSession()) {
            driverDAO = sqlSession().getMapper(DriverDAO.class);
            drivers = driverDAO.getAll();
            session.commit();
            sqlSession().close();

        } catch (IOException e) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);
        }
        return drivers;
    }
}
