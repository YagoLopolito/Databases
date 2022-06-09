package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.DriverDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.DriverService;
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
import java.util.ArrayList;
import java.util.List;

public class DriverServiceMyBatisImpl extends AbstractService implements DriverService {
    private final static Logger log = LogManager.getLogger(DriverServiceMyBatisImpl.class);

    @Override
    public void insert(Driver a) {
        DriverDAO driverDAO;
        try(SqlSession session = sqlSession()){
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e ) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Driver a) throws ConnectException {
        DriverDAO driverDAO;
        try(SqlSession session = sqlSession()){
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException  | MyBatisException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws ConnectException {
        DriverDAO driverDAO;
        try(SqlSession session = sqlSession()){
            driverDAO = session.getMapper(DriverDAO.class);
            driverDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException  | MyBatisException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public Driver getById(int id) throws ConnectException {
        DriverDAO driverDAO;
        Driver a;
        try(SqlSession session = sqlSession()){
            driverDAO = sqlSession().getMapper(DriverDAO.class);
            a = driverDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }
    @Override
    public List<Driver> getAll() {
        DriverDAO driverDAO;
        List<Driver> drivers;
        try(SqlSession session = sqlSession()){
            driverDAO = sqlSession().getMapper(DriverDAO.class);
            drivers = driverDAO.getAll();
            session.commit();
            sqlSession().close();

        } catch (IOException | MyBatisException e ) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);
        };
        return drivers;
    }
}
