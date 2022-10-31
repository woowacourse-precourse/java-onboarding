package onboarding.problem6;

import java.util.*;

public class Util {
    public static List<String> removeOverlap(List<String> list) {
        Set<String> forChange = new HashSet<>(list);
        List<String> changedList = new ArrayList<>(forChange);
        return changedList;
    }
}
