package org.clibankinjava.databaseutils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

//Singleton  - > Gang of Four
public class ToBankingWithSuccessDB implements Database {

    private EntityManager entityManger;

    private ToBankingWithSuccessDB() {}

    static class Inner {
        private Inner() {}

        private static final EntityManagerFactory entityManagerFactory = generateEntityManagerFactory();

        private static final Map<EntityManagerScope, EntityManager> entityManagerInstances
                = new EnumMap<>(EntityManagerScope.class);

        private static final ToBankingWithSuccessDB connToDb = new ToBankingWithSuccessDB();

        private static EntityManagerFactory generateEntityManagerFactory() {
            return Persistence.createEntityManagerFactory(
                    DatabaseUtilInfo.UNIT_PERSISTENCE_NAME.toString()
            );
        }
    }

    public EntityManager generateEntityManager(EntityManagerScope scope) {
        if (Inner.entityManagerInstances.containsKey(scope)) {
            return Inner.entityManagerInstances.get(scope);
        }

        this.entityManger = Inner.entityManagerFactory.createEntityManager();

        Inner.entityManagerInstances.put(scope, entityManger);
        return entityManger;
    }

    public Optional<EntityManagerFactory> getEntityManagerFactory() {
        return Optional.ofNullable(Inner.entityManagerFactory);
    }

    public static ToBankingWithSuccessDB getInstance() {
        return Inner.connToDb;
    }

    public Optional<EntityManager> getEntityManagerInstance(EntityManagerScope scope) {
        return Optional.ofNullable(Inner.entityManagerInstances.get(scope));
    }

    public Map<EntityManagerScope, EntityManager> getAllEntityManagers() {
        return Inner.entityManagerInstances;
    }

    @Override
    public int getNumberOfRecords() {
        return 0;
    }

    @Override
    public String getNameOfTheDatabase() {
        return null;
    }

    @Override
    public String getDescriptionOfTheTables() {
        return null;
    }
}

