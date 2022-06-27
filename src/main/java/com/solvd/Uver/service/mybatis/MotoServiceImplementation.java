package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.MotorcycleDAO;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.MyBatisException;
import com.solvd.Uver.service.MotorcycleService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class MotoServiceImplementation extends AbstractService implements MotorcycleService {
    private final static Logger log = LogManager.getLogger(MotoServiceImplementation.class);


    @Override
    public void insert(Moto a) throws MyBatisException, ConnectException {
        MotorcycleDAO motoDAO;
        try (SqlSession session = sqlSession()) {
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.insert(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis Error." + e);
        }
    }

    @Override
    public void update(Moto a) throws MyBatisException, ConnectException {
        MotorcycleDAO motoDAO;
        try (SqlSession session = sqlSession()) {
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.update(a);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis error." + e);
        }
    }

    @Override
    public void deleteById(int id) throws MyBatisException, ConnectException {
        MotorcycleDAO motoDAO;
        try (SqlSession session = sqlSession()) {
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.deleteById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("Error in MyBatis." + e);
        }
    }

    @Override
    public Moto getById(int id) throws MyBatisException, ConnectException {
        MotorcycleDAO motoDAO;
        Moto a;
        try (SqlSession session = sqlSession()) {
            motoDAO = sqlSession().getMapper(MotorcycleDAO.class);
            a = motoDAO.getById(id);
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("error in myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public List<Moto> getAll() throws MyBatisException, ConnectException {
        MotorcycleDAO motoDAO;
        List<Moto> motoList;
        try (SqlSession session = sqlSession()) {
            motoDAO = sqlSession().getMapper(MotorcycleDAO.class);
            motoList = motoDAO.getAll();
            session.commit();
            sqlSession().close();
        } catch (IOException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException(e);
        }
        return motoList;
    }
}
