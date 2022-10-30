package onboarding.problem7;

import java.util.List;
import java.util.HashMap;

public class Util {
    public static String getKeyFromValue(HashMap<String, Integer> hashMap, int value) {
        String result = "";
        for (String key :  hashMap.keySet()) {
            if (value == hashMap.get(key)) {
                result = key;
            }
        }
        return result;
    }
}
