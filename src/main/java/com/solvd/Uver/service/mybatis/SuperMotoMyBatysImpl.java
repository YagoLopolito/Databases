package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.SuperCarService;
import com.solvd.Uver.service.SuperMotoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class SuperMotoMyBatysImpl extends AbstractService implements SuperMotoService {
    private final static Logger log = LogManager.getLogger(SuperMotoMyBatysImpl.class);


    @Override
    public void insert(SuperMotorcycle a) {
        SuperMotoDAO superMotoDAO;
        try(SqlSession session = sqlSession()){
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e ) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(SuperMotorcycle a) throws ConnectException {
        SuperMotoDAO superMotoDAO;
        try(SqlSession session = sqlSession()){
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws ConnectException {
        SuperMotoDAO superMotoDAO;
        try(SqlSession session = sqlSession()){
            superMotoDAO = session.getMapper(SuperMotoDAO.class);
            superMotoDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public SuperMotorcycle getById(int id) throws ConnectException {
        SuperMotoDAO superMotoDAO;
        SuperMotorcycle a;
        try (SqlSession session = sqlSession()){
            superMotoDAO = sqlSession().getMapper(SuperMotoDAO.class);
            a = superMotoDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException | MyBatisException e) {
            log.error("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }
    @Override
    public List<SuperMotorcycle> getAll() throws ConnectException {
        SuperMotoDAO superMotoDAO;
        List<SuperMotorcycle> superCarList;
        try(SqlSession session = sqlSession()){

            superMotoDAO = sqlSession().getMapper(SuperMotoDAO.class);
            superCarList = superMotoDAO.getAll();

            session.commit();
            sqlSession().close();

        } catch (IOException | MyBatisException e ) {
            log.error("MyBatis error." + e);
            throw new RuntimeException(e);

        };
        return superCarList;
    }
}
