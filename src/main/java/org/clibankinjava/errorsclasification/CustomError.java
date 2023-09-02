package org.clibankinjava.errorsclasification;

import java.util.List;

public interface CustomError {
    String getContent();
    String getName();
    int getSeverity();
    int getNumberOfErrorsDefined();
    List<CustomError> allErrorsWithinCategory();
}
