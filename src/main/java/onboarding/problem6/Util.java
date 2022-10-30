package onboarding.problem6;

import java.util.*;

public class Util {
    public static boolean appearMoreThanTwice(List<String> repository, String lexim) {
        if (Collections.frequency(repository, lexim) >= 2) {
            return true;
        }
        return false;
    }
    public static List<String> sortAndReturn(HashMap<String, String> hashMap) {
        List<String> list = new ArrayList<>(hashMap.values());
        Collections.sort(list);
        return list;
    }
    public static List<String> removeOverlap(List<String> list) {
        Set<String> forChange = new HashSet<>(list);
        List<String> changedList = new ArrayList<>(forChange);
        return changedList;
    }
}
