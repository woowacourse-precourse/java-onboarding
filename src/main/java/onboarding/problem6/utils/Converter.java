package onboarding.problem6.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Converter {
    public static <T> List<T> convertSetToList (Set<T> set) {
        return new ArrayList<>(set);
    }

    public static List<String> convertSortedList (List<String> list) {
        Collections.sort(list);
        return list;
    }
}
