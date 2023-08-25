package org.clibankinjava.errorsclasification;

import java.util.List;

public interface CustomError {
    String getContent();
    String getName();
    int getSeverity();
    List<CustomError> allErrorsWithinCategory();
}
