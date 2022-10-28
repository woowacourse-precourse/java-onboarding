package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Character> chars = convertToList(cryptogram);

        int savedSize = chars.size();

        while (true) {
            int pivot = 0;
            while (pivot < chars.size() - 1) {
                if (chars.get(pivot) == chars.get(pivot + 1)) {
                    chars.remove(pivot + 1);
                    chars.remove(pivot);
                    continue;
                }
                pivot++;
            }

            if (savedSize == chars.size()) {
                break;
            }
            savedSize = chars.size();
        }

        return convertToString(chars);

    }

    private static List<Character> convertToList(String cryptogram) {
        List<Character> chars = new ArrayList<>();
        for (Character aChar : cryptogram.toCharArray()) {
            chars.add(aChar);
        }
        return chars;
    }

    private static String convertToString(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (Character aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }
}
