package dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FilterOption {
    ALL_LAUNCHES("All launches", "All"),
    LATEST_LAUNCHES("Latest launches", "Latest");

    private final String filter;
    private final String type;

    public String getFilter() {
        return filter;
    }

    public String getType() {
        return type;
    }
}
