package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return processCryptogram(cryptogram);
    }

    static String processCryptogram(String cryptogram) {
        boolean flag = false;

        while (!flag) {
            String newCryptogram = getCryptogram(cryptogram);
            flag = isSame(cryptogram, newCryptogram);
            cryptogram = newCryptogram;
        }

        return cryptogram;
    }

    static boolean isSame(String cryptogram, String newCryptogram) {
        if (cryptogram.equals(newCryptogram)) {
            return true;
        }
        return false;
    }

    static String getCryptogram(String cryptogram) {
        List<Character> stackList = new ArrayList<>();
        int len = cryptogram.length();

        for (int i = 0; i < cryptogram.length(); i++) {
            addStackList(stackList, i, cryptogram, len);
            i = getIdx(i, cryptogram, len);
        }

        return joinList(stackList);
    }

    static void addStackList(List<Character> stackList, int i, String cryptogram, int len) {
        if (canAddStackList(i, cryptogram, len)) {
            stackList.add(cryptogram.charAt(i));
        }
    }

    static int getIdx(int i, String cryptogram, int len) {
        if (!canAddStackList(i, cryptogram, len)) {
            int endIdx = getEndIdx(cryptogram, i + 1);
            int result = i + (endIdx - i);

            return result;
        }

        return i;
    }

    static boolean canAddStackList(int i, String cryptogram, int len) {
        if (i == len -1 || cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
            return true;
        }

        return false;
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
