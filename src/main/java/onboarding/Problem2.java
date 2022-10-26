package onboarding;

import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = new String(cryptogram);
        while (true) {
            if (isDistinctStr(answer))
                break;
            answer = decodingStr(answer);
        }
        return answer;
    }

    private static boolean isDistinctStr(String str) {
        char prev = '1';
        for (char ch : str.toCharArray()) {
            if (prev == ch)
                return false;
            prev = ch;
        }
        return true;
    }

    private static String decodingStr(String str) {
        LinkedList<Character> linkedList = getDecodingLinkedList(str);
        return makeStr(linkedList);
    }

    private static String makeStr(LinkedList<Character> linkedList) {
        StringBuffer sb = new StringBuffer();
        while (!linkedList.isEmpty()) {
            sb.append(linkedList.pollFirst());
        }
        return sb.toString();
    }

    private static LinkedList<Character> getDecodingLinkedList(String str) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            char prev = linkedList.isEmpty() ? '1' : linkedList.peekLast();
            if (prev == ch) {
                linkedList.pollLast();
                continue;
            }
            linkedList.addLast(ch);
        }
        return linkedList;
    }
}
