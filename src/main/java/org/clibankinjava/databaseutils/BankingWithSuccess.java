package org.clibankinjava.databaseutils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serial;
import java.io.Serializable;

public class BankingWithSuccess implements Serializable, Database {
    @Serial
    private static final long serialVersionUID = 4454268978731664877L;

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManger;

    private BankingWithSuccess() {}

    static class Inner {
        private Inner() {}
        private static final BankingWithSuccess connToDb = new BankingWithSuccess();
    }

    public static EntityManagerFactory generateEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bankingWithDB");
        return entityManagerFactory;
    }

    public static EntityManager generateEntityManager() {
        entityManger = entityManagerFactory.createEntityManager();
        return entityManger;
    }

    public static BankingWithSuccess getInstance() {
        return Inner.connToDb;
    }

    @Override
    public int getNumberOfRecords() {
        return 0;
    }

    @Override
    public String getNameOfTheDatabase() {
        return null;
    }

    @Serial
    public Object readResolve() {
        return Inner.connToDb;
    }
}
