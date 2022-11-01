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
                    if (i == len - 1) {
                        chDeque.removeLast();
                    }
                    continue;
                }

                if (continuous) {
                    chDeque.removeLast();
                    continuous = false;
                    cnt = true;
                }

                chDeque.addLast(cryptoList.get(i));
            }
            cryptoList = initialList(chDeque);
            continuous = false;
        } while (cnt);

        return printList(cryptoList);
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

    static String printList(List list){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
