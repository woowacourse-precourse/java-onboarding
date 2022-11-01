package onboarding.problem6;

import java.util.HashMap;
import java.util.Map;

class TokenMap {
    private final Map<String, String> map;

    public TokenMap() {
        this.map = new HashMap<>();
    }

    public boolean has(String key) {
        return map.get(key) != null;
    }

    public String get(String key) {
        return map.get(key);
    }

    public void set(String key, String value) {
        map.put(key, value);
    }
}
