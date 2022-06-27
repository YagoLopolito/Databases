package com.solvd.Uver.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryUtil {
    private static final Logger log = LogManager.getLogger(SqlSessionFactoryUtil.class);
    private static final SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    private static Reader reader;
    private static SqlSessionFactory INSTANCE;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            setReader(reader);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    private SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = builder.build(reader);
        }
        return INSTANCE;
    }

    public static Reader getReader() {
        return reader;
    }

    public static void setReader(Reader reader) {
        SqlSessionFactoryUtil.reader = reader;
    }

}