package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
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
}
