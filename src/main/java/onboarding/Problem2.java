package onboarding;

import java.util.ArrayList;

public class Problem2 {
    static ArrayList<Character> cryptogramList = new ArrayList<>();

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static void addCryptogramList(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            cryptogramList.add(cryptogram.charAt(i));
        }
    }

    public static int compareChar(String cryptogram) {
        int count = 0;

        for (int a = 0; a < cryptogramList.size() - 1; ) {
            char firstChar = cryptogramList.get(a);
            char nextChar = cryptogramList.get(a + 1);
        }
        return count;
    }

    public static boolean isSame(char firstChar, char nextChar) {
        if (firstChar == nextChar) {
            return true;
        }
        return false;
    }
}