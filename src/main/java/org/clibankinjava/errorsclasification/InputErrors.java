package org.clibankinjava.errorsclasification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum InputErrors implements CustomError {

    NULL_OR_EMPTY_TEXT("null_or_empty_text", 3,
            String.format("INPUT_ERROR, SEV: %s - Input value is null or empty. Please provide a proper value!", Severities.THREE)),

    INCORRECT_NUMERICAL_VALUE("incorrect_numerical_value", 3,
            String.format("INPUT_ERROR, SEV: %s - Input numerical value is not ok. Please provide another one!", Severities.THREE)),

    NULL_OR_BLANK_USERNAME("null_or_blank_username", 2,
    String.format("INPUT_ERROR, SEV: %s - Blank or null value for username value is not accepted!", Severities.TWO)),

    NULL_OR_BLANK_MENU_OPTION_GIVEN("null_or_blank_menu_option_to_be_added", 3,
            String.format("INPUT_ERROR, SEV: %s - Blank or null value for menu option to be added is not accepted", Severities.THREE)),

    INDEX_FOR_MENU_OPTION_NOT_VALID("index_for_adding_a_menu_option_not_valid", 3,
            String.format("INPUT_ERROR, SEV: %s - Index for menu option to add it is not valid!", Severities.THREE));

    private final String content;
    private final String name;
    private final int severity;

    InputErrors(String name, int severity, String content) {
        this.name = name;
        this.severity = severity;
        this.content = content;
    }

    @Override
    public List<CustomError> allErrorsWithinCategory() {
        return new ArrayList<>(Arrays.asList(NULL_OR_EMPTY_TEXT, INCORRECT_NUMERICAL_VALUE, NULL_OR_BLANK_USERNAME,
                NULL_OR_BLANK_MENU_OPTION_GIVEN, INDEX_FOR_MENU_OPTION_NOT_VALID));
    }

    @Override
    public int getNumberOfErrorsDefined() {
        return allErrorsWithinCategory().size();
    }

    @Override
    public String toString() {
        return this.content;
    }
}
