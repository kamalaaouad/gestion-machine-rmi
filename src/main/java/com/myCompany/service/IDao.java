package com.myCompany.service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDao<T> extends Remote {
    boolean create(T o) throws RemoteException;
    boolean update(T o) throws RemoteException;
    boolean delete(T o) throws RemoteException;
    List<T> findAll() throws  RemoteException;
    T findById(long id) throws RemoteException;
}

