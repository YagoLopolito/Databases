package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.SuperCarService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class SuperCarMyBatysImpl extends AbstractService implements SuperCarService {
    private final static Logger log = LogManager.getLogger(SuperCarMyBatysImpl.class);


    @Override
    public void insert(SuperCar a) {
        SuperCarDAO superCarDAO;
        try(SqlSession session = sqlSession()){
            superCarDAO = session.getMapper(SuperCarDAO.class);
            superCarDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e ) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(SuperCar a) throws ConnectException {
        SuperCarDAO superCarDAO;
        try(SqlSession session = sqlSession()){
            superCarDAO = session.getMapper(SuperCarDAO.class);
            superCarDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws ConnectException {
        SuperCarDAO superCarDAO;
        try(SqlSession session = sqlSession()){
            superCarDAO = session.getMapper(SuperCarDAO.class);
            superCarDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public SuperCar getById(int id) throws ConnectException {
        SuperCarDAO superCarDAO;
        SuperCar a;
        try (SqlSession session = sqlSession()){
            superCarDAO = sqlSession().getMapper(SuperCarDAO.class);
            a = superCarDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }
    @Override
    public List<SuperCar> getAll() throws ConnectException {
        SuperCarDAO superCarDAO;
        List<SuperCar> superCarList;
        try(SqlSession session = sqlSession()){

            superCarDAO = sqlSession().getMapper(SuperCarDAO.class);
            superCarList = superCarDAO.getAll();

            session.commit();
            sqlSession().close();

        } catch (IOException | MyBatisException e ) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);

        };
        return superCarList;
    }
}
