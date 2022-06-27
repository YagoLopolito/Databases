package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.SuperMotoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class SuperMotoImplementation extends AbstractService implements SuperMotoService {
    private final static Logger log = LogManager.getLogger(SuperMotoImplementation.class);


    @Override
    public void insert(SuperMotorcycle a) throws MyBatisException, ConnectException {
        SuperMotoDAO superMotoDAO;
        try (SqlSession session = sqlSession()) {
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis Error." + e);
        }
    }

    @Override
    public void update(SuperMotorcycle a) throws MyBatisException, ConnectException {
        SuperMotoDAO superMotoDAO;
        try (SqlSession session = sqlSession()) {
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis error." + e);
        }
    }

    @Override
    public void deleteById(int id) throws MyBatisException, ConnectException {
        SuperMotoDAO superMotoDAO;
        try (SqlSession session = sqlSession()) {
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("Error in MyBatis." + e);
        }
    }

    @Override
    public SuperMotorcycle getById(int id) throws MyBatisException, ConnectException {
        SuperMotoDAO superMotoDAO;
        SuperMotorcycle a;
        try (SqlSession session = sqlSession()) {
            superMotoDAO = sqlSession().getMapper(SuperMotoDAO.class);
            a = superMotoDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<SuperMotorcycle> getAll() throws MyBatisException, ConnectException {
        SuperMotoDAO superMotoDAO;
        List<SuperMotorcycle> superCarList;
        try (SqlSession session = sqlSession()) {

            superMotoDAO = sqlSession().getMapper(SuperMotoDAO.class);
            superCarList = superMotoDAO.getAll();

            session.commit();
            sqlSession().close();

        } catch (IOException e) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);
        }
        return superCarList;
    }
}
