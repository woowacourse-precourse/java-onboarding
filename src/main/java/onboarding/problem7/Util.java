package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashSet;
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
    public static List<String> removeOverlap(List<String> target) {
        HashSet<String> removedSet = new HashSet<>(target);
        ArrayList<String> removedList = new ArrayList<>(removedSet);
        return removedList;
    }
}
