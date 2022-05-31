package com.solvd.Uver.daos;

import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface DAO<T, K> {
    void insert(T a) throws DAOException;

    void delete(int a) throws DAOException;

    void modify(T a) throws DAOException;

    List<T> giveAll() throws DAOException;

    T give(K id) throws DAOException;
}
