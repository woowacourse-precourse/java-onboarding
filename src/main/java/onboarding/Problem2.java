package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {

        List<String> list = Arrays.stream(cryptogram.split(""))
            .collect(Collectors.toList());

        while(hasDuplication(list)) {
            removeSerialDuplication(list);
        }

        return listToString(list);
    }


    private static boolean hasDuplication(List<?> list) {
        for (int i = 1; i < list.size(); i++) {
            if(isSameAsPrevious(list, i)) {
                return true;
            }
        }
        return false;
    }

    private static void removeSerialDuplication(List<?> list) {

        for (int i = 1; i < list.size(); i++) {

            if (isSameAsPrevious(list, i)) {

                removeWithPrevious(list, i);
            }
        }
    }

    private static void removeWithPrevious(List<?> list, int index) {
        list.remove(index);
        list.remove(index-1);
    }

    private static boolean isSameAsPrevious(List<?> list, int index) {
        return list.get(index).equals(list.get(index - 1));
    }

    private static String listToString(List<?> list) {

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        return sb.toString();
    }
}
