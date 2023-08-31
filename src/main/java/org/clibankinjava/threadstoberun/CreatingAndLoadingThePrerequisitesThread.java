package org.clibankinjava.threadstoberun;

import org.clibankinjava.cache.CachedObjects;
import org.clibankinjava.components.headers.HeaderConstruct;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.components.menus.IMenu;
import org.clibankinjava.components.menus.MainMenuBuilder;
import org.clibankinjava.workwithinput.CatchAndProcessingInput;
import org.clibankinjava.workwithinput.MainProcessingInput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CreatingAndLoadingThePrerequisitesThread implements Callable<Map<String, Object>> {
    private final CountDownLatch latch;

    public CreatingAndLoadingThePrerequisitesThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Map<String, Object> call() throws Exception {
        Map<String, Object> objects = CachedObjects.loadCachedObjects();

        try {
            return objects;
        } finally {
            latch.countDown();
        }
    }
}
