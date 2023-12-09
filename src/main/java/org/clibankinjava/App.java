package org.clibankinjava;

import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Check;
import org.clibankinjava.customprinting.CustomPrinting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
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

//        ToBankingWithSuccessDB toBankingDB = ToBankingWithSuccessDB.getInstance();
//
//        EntityManager em = toBankingDB.generateEntityManager(EntityManagerScope.USERS);
//        EntityTransaction transaction = null;
//
//        try (em) {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }

        //----------------------------------------------------------------------------

        Check check = new Check();

        check.setId(44L);
        check.setName("Valentin Soare");
        check.setAddress("Str. Lucretiu Patrascanu, Nr. 9, Bl. Y2, Ap. 21");
        check.setDate(LocalDate.of(2008, Month.AUGUST, 11));
        check.setAmountToPay(new BigDecimal("1000000"));
        check.setPayToTheOrderOf("Tudorina Soare");
        check.setObjectForPayment("Debts");
        check.setAccountNumber("18711119520010");
        check.setCheckNumber("1919879923");
        check.setAccount(null);

        CustomPrinting.drawABlankCheck(check);
    }
}
