package org.clibankinjava.cache;

import org.clibankinjava.components.headers.HeaderConstruct;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.components.menus.IMenu;
import org.clibankinjava.components.menus.MainMenuBuilder;
import org.clibankinjava.workwithinput.CatchAndProcessingInput;
import org.clibankinjava.workwithinput.MainProcessingInput;

import java.util.HashMap;
import java.util.Map;

public class CachedObjects {
    private static final Map<String, Object> cachedObjects;

    private CachedObjects() {}

    static {
        cachedObjects = new HashMap<>();
    }

    public static void addObjectInCache(String key, Object value) {
        cachedObjects.put(key, value);
    }

    public static Map<String, Object> getCachedObjects() {
        return cachedObjects;
    }

    public static Map<String, Object> loadCachedObjects() throws InterruptedException {
        IHeader header = new HeaderConstruct().setupHeaderMessage("republica bank", true)
                .setupSubHeaderMessage("one click stop", false)
                .setupEmptySpacesFromLeftEdgeScreen(5)
                .setupEmptySpacesFromTopEdgeScreen(1)
                .setupEmptySpacesBelowTheHeader(2)
                .setupLengthOfBorders()
                .build();
        cachedObjects.put("header", header);

        IMenu menu = new MainMenuBuilder().setupHeader(header)
                .setupNumberOfEntries(6)
                .setupEntries("add customer, change name, check balance, modify balance, bank summary, quit")
                .setMessageAtTheBottom("please choose an option: ")
                .setupEmptySpacesFromLeftEdgeScreen(5)
                .setupEmptySpacesFromTopEdgeScreen(1)
                .setupEmptySpacesBelow(2)
                .build();
        cachedObjects.put("menu", menu);

        cachedObjects.put("processinginput", new MainProcessingInput("main menu option", 5));

        return cachedObjects;
    }
}
