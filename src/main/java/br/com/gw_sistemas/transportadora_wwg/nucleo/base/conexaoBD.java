package br.com.gw_sistemas.transportadora_wwg.nucleo.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class conexaoBD {

    private EntityManagerFactory mManagerFactory;
    private EntityManager mManager;

    public conexaoBD() {
            mManagerFactory = Persistence.createEntityManagerFactory("transportadoraWWG");
            mManager = mManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {

            return mManager;
    }
}
