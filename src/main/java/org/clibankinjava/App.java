package org.clibankinjava;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.clibankinjava.databaseutils.ToBankingWithSuccessDB;
import org.clibankinjava.databaseutils.EntityManagerScope;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CountDownLatch latch = new CountDownLatch(2);
//
//        ThreadPoolExecutor exec = new ThreadPoolExecutor(3, 6, 30,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

//        //------------
//        LoadingEffect progressBar = LoadingFactory.getLoadEffect("linesdirection", "load banking application",
//                5);
//
//        Future<Map<String, Component>> mainComponentsCreation =
//                exec.submit(new CreatingAndLoadingThePrerequisitesThread(latch));
//
//        exec.submit(new ProgressBarThread(latch, progressBar,40, 5,
//                2, 2, 35));
//
//        latch.await();
//
//        exec.submit(new PrintingTheMenuThread( (IMenu) mainComponentsCreation.get().get("menu")));
//
//        String inputCP = ((CatchAndProcessingInput) mainComponentsCreation.get().get("processinginput")).catchInputFromUser();
//
//        exec.shutdown();
        //------------

//        Login screen = new LoginScreen(5, 2, 2);
//        screen.drawScreen('-', '|', 5, 30, 5);


//        TakeInputForLogin login = new TakeInputForLogin("republica bank", "one click stop");
//        login.askUserAndPassword(5, 0, 2);


//        System.out.printf("\u001b[10B%s", "CCC");
        //--------------------------------

//        LoadingEffect progressBar = LoadingFactory.getLoadEffect("linesdirection", "load banking application",
//                10);
//
//        progressBar.loadProgressIndicator(40, 5, 2,
//                2, 75);

        //------------------------------------------------------------------------

        ToBankingWithSuccessDB toBankingDB = ToBankingWithSuccessDB.getInstance();

        EntityManager em = toBankingDB.generateEntityManager(EntityManagerScope.USERS);
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
