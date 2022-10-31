package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class RecommendMap {
    private final Map<String, Integer> stringIntegerMap;


    public RecommendMap() {
        this.stringIntegerMap = new HashMap<>();
    }

    public Map<String, Integer> getStringListMap() {
        return stringIntegerMap;
    }

    public void put(String key, int value) {
        stringIntegerMap.put(key, value);
    }

    public void add(UserId key, int value) {
        int before = this.get(key.getId());
        stringIntegerMap.put(key.getId(), before + value);
    }

    public int get(String key) {
        return stringIntegerMap.getOrDefault(key, 0);
    }
}
