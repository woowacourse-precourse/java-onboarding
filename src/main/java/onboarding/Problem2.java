package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return processCryptogram(cryptogram);
    }

    static String processCryptogram(String cryptogram) {
        while (true) {
            String newCryptogram = getCryptogram(cryptogram);

            if (newCryptogram.equals(cryptogram)) {
                return newCryptogram;
            }

            cryptogram = newCryptogram;
        }
    }

    static String getCryptogram(String cryptogram) {
        List<Character> stackList = new ArrayList<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (i == cryptogram.length() -1 || cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                stackList.add(cryptogram.charAt(i));
            }

            else if(cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                int endIdx = getEndIdx(cryptogram, i + 1);
                i += endIdx - i;
            }
        }

        return joinList(stackList);
    }

    static int getEndIdx(String cryptogram, int i) {
        char target = cryptogram.charAt(i);
        while (i < cryptogram.length() -1 && cryptogram.charAt(i + 1) == target) {
            i++;
        }

        return i;
    }

    static String joinList(List<Character> stackList) {
        StringBuilder result = new StringBuilder();

        stackList.stream()
            .forEach(ele -> result.append(ele));

        return result.toString();
    }
}
