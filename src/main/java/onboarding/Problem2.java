package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2 {
    public static String ALPHABET_DELIMETER = "abcdefghijklmnopqrstuvwxyz";
    public static List<String> list;

    public static String solution(String cryptogram) {
        String answer = "answer";
        list = new LinkedList<String>();

        addLettersInList(cryptogram);
        traverseList(list);
        answer = listToString(list);

        return answer;
    }

    private static String listToString(List<String> list) {
        String answer = "";
        for(String alphabet : list){
            answer+=alphabet;
        }
        return answer;
    }

    private static boolean isSameLetter(int i) {
        if (list.get(i).equals(list.get(i + 1))) {
            removeSameLetter(i);
            return true;
        }
        return false;
    }

    private static void removeSameLetter(int i) {
        list.remove(i + 1);
        list.remove(i);
    }

    private static void traverseList(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (isSameLetter(i)) {
                i = -1;
            }
        }
    }

    private static void addLettersInList(String cryptogram) {
        StringTokenizer st = new StringTokenizer(cryptogram, ALPHABET_DELIMETER,true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
    }
}
