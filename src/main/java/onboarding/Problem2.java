package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (isComposedOfSame(cryptogram)) {
            return "";
        }
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = cryptogram.toCharArray();
        for (char c : chars) {
            if (!list.isEmpty() && list.getLast() == c) {
                list.removeLast();
            } else {
                list.addLast(c);
            }
        }
        if (list.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(list.size());
        while (list.size() != 0) {
            sb.append(list.removeFirst());
        }
        return sb.toString();
    }

    private static boolean isComposedOfSame(String cryptogram) {
        char target = cryptogram.charAt(0);
        for (char c : cryptogram.toCharArray()) {
            if (target != c) {
                return false;
            }
        }
        return true;
    }
}
