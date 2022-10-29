package onboarding;

import java.util.*;

public class Problem2 {
    public static List<String> crypto;
    public static String solution(String cryptogram) {
        String answer = "answer";
        crypto = new LinkedList<String>();
        turnIntoList(cryptogram);
        iterateList(crypto);
        answer = concatList(crypto);
        return answer;
    }

    private static void iterateList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                list.remove(i);
                i--;
            }
        }
    }
    private static void turnIntoList(String cryptogram) {
        StringTokenizer st = new StringTokenizer(cryptogram, "abcdefghijklmnopqrstuvwxyz", true);
        while (st.hasMoreTokens()) {
            crypto.add(st.nextToken());
        }
    }
    private static String concatList(List<String> list) {
        String str = "";
        for(String e : list) {
            str += e;
        }
        return str;
    }
}
