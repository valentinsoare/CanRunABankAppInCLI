package org.clibankinjava.customdatastructures.anothertypeofarraylist;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class EnhancedArrayList<E> extends ArrayList<E> {
    private static int DEFAULT_CAPACITY;
    private boolean isEntirelyListRotated;

    static {
        DEFAULT_CAPACITY = 4;
    }

    public EnhancedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public EnhancedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public EnhancedArrayList(@NotNull Collection<? extends E> c) {
        super(c);
    }

    public void rotate(int digitsToRotateToLeft) {
        EnhancedArrayList<E> tempStruct = new EnhancedArrayList<>();



    }
}

