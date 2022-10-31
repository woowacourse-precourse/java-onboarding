package onboarding.problem7.utils;

import java.util.List;

public class Slicer {
    public static <T> List<T> sliceList (List<T> list, int count) {
        return list.subList(0, count + 1);
    }
}
