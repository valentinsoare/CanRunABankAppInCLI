package org.clibankinjava;

import org.clibankinjava.cache.CachedObjects;
import org.clibankinjava.components.login.TakeInputForLogin;

import java.util.concurrent.ExecutionException;


public class App {
    public static void main( String[] args ) throws InterruptedException, ExecutionException {
//        CountDownLatch latch = new CountDownLatch(2);
        CachedObjects.loadCachedObjects();
//        ThreadPoolExecutor exec = new ThreadPoolExecutor(3, 5, 30,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//
//        //------------
//
//        ILoading progressBar = LoadingFactory.getLoadEffect("progressbar", "load banking application",
//                5);
//
//        Future<List<?>> mainComponentsCreation =
//                exec.submit(new CreatingAndLoadingThePrerequisitesThread(latch));
//
//        exec.submit(new ProgressBarThread(latch, progressBar,40, 5,
//                2, 2, 75));
//
//        latch.await();
//
//        exec.submit(new PrintingTheMenuThread( (Menu) mainComponentsCreation.get().get(1)));
//
//        String inputCP = ((CatchAndProcessingInput) mainComponentsCreation.get().get(2)).catchInputFromUser();
//        //------------
//
//        exec.shutdown();
//        Login screen = new LoginScreen(5, 2, 2);
//        screen.drawScreen('-', '|', 5, 30, 5);
        TakeInputForLogin login = new TakeInputForLogin("republica bank", "one click stop");
        login.askUserAndPassword(5, 0, 2);


//        System.out.printf("\u001b[10B%s", "CCC");
    }
}
