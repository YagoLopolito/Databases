package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.ClientDAO;
import com.solvd.Uver.daos.implementation.MySQLClientDAO;
import com.solvd.Uver.entities.Client;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.ClientService;

import java.sql.Connection;
import java.util.List;

public class ClientsServiceImplementation implements ClientService {
    private final Connection conn;

    public ClientsServiceImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void give(Client a) {
        ClientDAO clients = new MySQLClientDAO(conn);
        try {
            clients.insert(a);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modify(Client entities) {
        ClientDAO clients = new MySQLClientDAO(conn);
        try {
            clients.modify(entities);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        ClientDAO clients = new MySQLClientDAO(conn);
        try {
            clients.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getOne(int id) {
        ClientDAO clients = new MySQLClientDAO(conn);
        Client client = null;
        try {
            client = clients.give(id);

        } catch (DAOException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> getAll() {
        ClientDAO clients = new MySQLClientDAO(conn);
        List<Client> clientList = null;
        try {
            clientList = clients.giveAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return clientList;
    }
}
