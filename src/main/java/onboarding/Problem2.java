package onboarding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

    public static String solution(String cryptogram) {
        while (true) {
            String trans = removeDuplicated(cryptogram);
            if (trans.length() == cryptogram.length()) {
                break;
            }
            cryptogram = trans;
        }
        return cryptogram;
    }

    static String removeDuplicated(String cryptogram) {
        boolean[] toRemoveArr = new boolean[cryptogram.length()];
        Queue<Integer> myQ = new LinkedList<>();
        char beforeChar = '.';
        for (int i = 0; i < cryptogram.length(); ++i) {
            char nowChar = cryptogram.charAt(i);
            if (beforeChar != '.') {
                if (beforeChar != nowChar) {
                    if (myQ.size() != 1) {
                        while (!myQ.isEmpty()) {
                            toRemoveArr[myQ.poll()] = true;
                        }
                    } else {
                        myQ.clear();
                    }
                }
            }
            myQ.offer(i);
            beforeChar = nowChar;
        }

        if (myQ.size() != 1) {
            while (!myQ.isEmpty()) {
                toRemoveArr[myQ.poll()] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (!toRemoveArr[i]) {
                sb.append(cryptogram.charAt(i));
            }
        }
        return sb.toString();
    }
}
