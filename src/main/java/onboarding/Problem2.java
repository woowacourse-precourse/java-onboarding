package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {

        Deque<Character> chDeque = new LinkedList<>();
        List<Character> cryptoList = StringToList(cryptogram);
        boolean cnt;
        boolean continuous = false;

        do {
            cnt = false;
            int len = cryptoList.size();
            for (int i = 0; i<len; i++) {
                if (!chDeque.isEmpty() && chDeque.getLast() == cryptoList.get(i)) {
                    continuous = true;
                    continue;
                }
                if (continuous) {
                    chDeque.removeLast();
                    continuous = false;
                    cnt = true;
                } else {
                    chDeque.addLast(cryptoList.get(i));
                }
            }
            cryptoList = initialList(chDeque);
        } while (cnt);

        return printDeque(chDeque);
    }

    static List StringToList(String str) {
        List result = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i));
        }
        return result;
    }

    static List initialList(Deque deq) {
        List result = new ArrayList();
        while (!deq.isEmpty()) {
            result.add(deq.removeFirst());
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
