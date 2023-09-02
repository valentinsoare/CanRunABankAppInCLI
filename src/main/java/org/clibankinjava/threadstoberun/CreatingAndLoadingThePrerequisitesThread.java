package org.clibankinjava.threadstoberun;

import org.clibankinjava.Component;
import org.clibankinjava.cache.LoadingCachedObjectsFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CreatingAndLoadingThePrerequisitesThread implements Callable<Map<String, Component>> {
    private final CountDownLatch latch;

    public CreatingAndLoadingThePrerequisitesThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Map<String, Component> call() {
        Map<String, Component> objects = LoadingCachedObjectsFactory.returnedCachedObjectsAsADictionary();

        try {
            return objects;
        } finally {
            latch.countDown();
        }
    }
}
