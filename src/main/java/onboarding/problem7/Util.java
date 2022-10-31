package onboarding.problem7;

import java.util.*;

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
    public static List<Map.Entry<String, Integer>> sameScoreSort(List<Map.Entry<String, Integer>> entryList) {
        List<Map.Entry<String, Integer>> newEntryList = new LinkedList<>();
        int value = entryList.get(0).getValue();
        List<Map.Entry<String, Integer>> temp = new LinkedList<>();
        for (int i = 0; i < entryList.size(); i++) {
            if (entryList.get(i).getValue() != value) {
                temp.sort(Map.Entry.comparingByKey());
                newEntryList.addAll(temp);
                temp.clear();
            }
            temp.add(entryList.get(i));
            value = entryList.get(i).getValue();
        }
        temp.sort(Map.Entry.comparingByKey());
        Collections.reverse(temp);
        newEntryList.addAll(temp);
        return newEntryList;
    }
}
