package onboarding;

import java.util.ArrayList;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
    }

    private static ArrayList<Character> convertStringToArrayList(String cryptogram) {
        ArrayList<Character> list = new ArrayList<>();
        char[] characterArray = cryptogram.toCharArray();
        for(char c : characterArray) list.add(c);
        return list;
    }

    private static String convertArrayListToString(ArrayList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character item : list) sb.append(item);
        return sb.toString();
    }
}
