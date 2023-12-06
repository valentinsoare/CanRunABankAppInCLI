package org.clibankinjava.cache;

import org.clibankinjava.components.Component;
import org.clibankinjava.components.headers.Header;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.components.loading.LoadingEffect;
import org.clibankinjava.components.loading.ProgressBar;
import org.clibankinjava.components.loading.ProgressLinesDirection;
import org.clibankinjava.components.menus.Menu;
import org.clibankinjava.workwithinput.CatchAndProcessingInput;
import org.clibankinjava.workwithinput.MenuProcessingInput;

import java.util.Map;

public final class LoadingCachedObjectsFactory {
    private LoadingCachedObjectsFactory() {}
    private static final Map<String, Component> objects;

    static {
        try {
            objects = CachedObjects.loadCachedObjects();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static IHeader loadHeader() {
        return Header.getNewInstance((IHeader) objects.get("header"));
    }

    public static LoadingEffect loadEffectProgressLines() {
        return ProgressBar.getNewInstanceOfProgressBar((ProgressBar) objects.get("progresslines"));
    }

    public static LoadingEffect loadEffectLinesDirection() {
        return ProgressLinesDirection
                .getNewInstanceOfProgressLinesDirection((ProgressLinesDirection)  objects.get("linesdirection"));
    }

    public static LoadingEffect loadEffectProgressBar() {
        return ProgressBar.getNewInstanceOfProgressBar((ProgressBar) objects.get("progressbar"));
    }

    public static Menu loadMenu() {
        return Menu.getNewInstance((Menu) objects.get("menu"));
    }

    public static CatchAndProcessingInput loadProcessingInput() {
        return MenuProcessingInput
                .getNewInstance((MenuProcessingInput) objects.get("processinginput"));
    }

    public static Map<String, Component> returnedCachedObjectsAsADictionary() {
        return objects;
    }
}
