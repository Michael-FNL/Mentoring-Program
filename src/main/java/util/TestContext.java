package util;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<String, Object> data = new HashMap<>();

    public <T> void set(final String key, final T value) {
        data.put(key, value);
    }

    public <T> T get(final String key, final Class<T> clazz) {
        return clazz.cast(data.get(key));
    }
}
