package com.solvd.Uver.service.mybatis;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.MotorcycleDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.MotorcycleService;
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

public class MotoServiceMyBatisImpl implements MotorcycleService {
    private final static Logger log = LogManager.getLogger(CarServiceMyBatisImpl.class);
    private final static String MYBATIS = DBPropertiesUtil.getString(Constants.MYBATIS);

    @Override
    public void insert(Moto a) {
        MotorcycleDAO motoDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.insert(a);
            session.commit();
        } catch (IOException | DAOException e ) {
            log.info("MyBatis Error." + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Moto a) throws ConnectException {
        MotorcycleDAO motoDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.update(a);
            session.commit();
        } catch (IOException  | DAOException e) {
            log.info("MyBatis error." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) throws ConnectException {
        MotorcycleDAO motoDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            motoDAO = session.getMapper(MotorcycleDAO.class);
            motoDAO.deleteById(id);
            session.commit();
        } catch (IOException  | DAOException e) {
            log.info("Error in MyBatis." + e);
            throw new RuntimeException();
        }
    }

    @Override
    public Moto getById(int id) throws ConnectException {
        MotorcycleDAO motoDAO;
        Moto a;
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            motoDAO = sqlSessionFactory.openSession().getMapper(MotorcycleDAO.class);
            a = motoDAO.getById(id);
        } catch (IOException | DAOException e) {
            log.info("error in myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }
    @Override
    public List<Moto> getAll() throws ConnectException {
        MotorcycleDAO motoDAO;
        List<Moto> motoList;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            motoList = new ArrayList<>();
            motoDAO = sqlSessionFactory.openSession().getMapper(MotorcycleDAO.class);
            motoList = motoDAO.getAll();

        } catch (IOException | DAOException e ) {
            log.info("MyBatis error." + e);
            throw new RuntimeException(e);
        };
        return motoList;
    }
}
