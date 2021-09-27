package com.challenge.backend.common.enumeration;
/**
 * @author Francisco
 *
 */
public enum LogTagEnum {
    TAG_SUCCESS_CHARACTER("Successful customer response"),
    TAG_SUCCESS_LOCATION("Successful location response"),
    TAG_SUCCESS_ENTITY("Success to complete Entity Response"),
    TAG_SUCCESS_FULL("Success");

    private String value;

    LogTagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
