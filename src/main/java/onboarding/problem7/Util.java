package onboarding.problem7;

import java.util.*;
import java.util.Map.Entry;

public class Util {
    public static List<String> removeOverlap(List<String> target) {
        HashSet<String> removedSet = new HashSet<>(target);
        ArrayList<String> removedList = new ArrayList<>(removedSet);
        return removedList;
    }
    public static List<Map.Entry<String, Integer>> sameEntryValueSort(List<Map.Entry<String, Integer>> entryList) {
        List<Map.Entry<String, Integer>> newEntryList = new LinkedList<>();
        int beforeValue = entryList.get(0).getValue();
        List<Map.Entry<String, Integer>> temp = new LinkedList<>();

        for (int i = 0; i < entryList.size(); i++) {
            Entry<String, Integer> entry = entryList.get(i);
            if (entry.getValue() != beforeValue || i == entryList.size() - 1) {
                temp.sort(Map.Entry.comparingByKey(Collections.reverseOrder()));
                newEntryList.addAll(temp);
                temp.clear();
            }
            temp.add(entry);
            beforeValue = entry.getValue();
        }
        newEntryList.addAll(temp);
        return newEntryList;
    }
}
