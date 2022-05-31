package com.solvd.Uver.service;

import com.solvd.Uver.entities.Client;

import java.util.List;

public interface ClientService {
    void give(Client a);

    void modify(Client entities);

    void delete(int id);

    Client getOne(int id);

    List<Client> getAll();

}
