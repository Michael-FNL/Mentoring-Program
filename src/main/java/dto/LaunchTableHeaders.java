package dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LaunchTableHeaders {
    NAME("name"),
    START("start"),
    TOTAL("total"),
    PASSED("passed"),
    FAILED("failed"),
    SKIPPED("skipped"),
    PRODUCT_BUG("product bug"),
    AUTO_BUG("auto bug"),
    SYSTEM_ISSUE("system issue"),
    TO_INVESTIGATE("to investigate");

    private final String header;

    public String getHeader() {
        return header;
    }
}
