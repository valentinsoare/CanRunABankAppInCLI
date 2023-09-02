package org.clibankinjava.cache;

import lombok.Getter;
import org.clibankinjava.Component;
import org.clibankinjava.components.headers.HeaderConstruct;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.components.loading.LoadingEffect;
import org.clibankinjava.components.loading.LoadingFactory;
import org.clibankinjava.components.menus.IMenu;
import org.clibankinjava.components.menus.MainMenuBuilder;
import org.clibankinjava.workwithinput.MainProcessingInput;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CachedObjects {
    private static final Map<String, Component> cachedObjects;

    static {
        cachedObjects = new HashMap<>();
    }

    public void addObjectInCache(String key, Component value) {
        cachedObjects.put(key, value);
    }

    public static Map<String, Component> loadCachedObjects() throws InterruptedException {
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

        String messageForLoading = "load banking application";
        int spaceForLeft = 5;

        LoadingEffect linesDirection = LoadingFactory.getLoadEffect("linesdirection", messageForLoading,
                spaceForLeft);
        cachedObjects.put("linesdirection", linesDirection);

        LoadingEffect progressLines = LoadingFactory.getLoadEffect("progresslines", messageForLoading,
                spaceForLeft);
        cachedObjects.put("progresslines", progressLines);

        LoadingEffect progressBar = LoadingFactory.getLoadEffect("progressbar", messageForLoading,
                spaceForLeft);
        cachedObjects.put("progressbar", progressBar);

        return cachedObjects;
    }
}
