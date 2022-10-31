package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {

        Deque<Character> chDeque = new LinkedList<>();
        List cryptoList = StringToList(cryptogram);

        do {

        }
        return printDeque(chDeque);
    }

    static List StringToList(String str) {
        List result = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i));
        }
        return result;
    }

    static String printDeque(Deque<Character> chDeque){
        String result = "";
        while (!chDeque.isEmpty()) {
            result += Character.toString(chDeque.removeFirst());
        }
        return result;
    }
}
