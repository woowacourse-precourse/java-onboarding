package onboarding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static List<String> crypto;
    public static String solution(String cryptogram) {
        String answer = "answer";
        crypto = Arrays.asList(cryptogram);
        iterateList(crypto);
        answer = concatList(crypto);
        return answer;
    }

    private static void iterateList(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                list.remove(i);
                i--;
            }
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
