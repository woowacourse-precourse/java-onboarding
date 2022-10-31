package onboarding;

import java.util.ArrayList;
import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeContinuousCharacters(cryptogram);
    }

    private static String removeContinuousCharacters(String cryptogram) {
        ArrayList<Character> list = convertStringToArrayList(cryptogram);
        while (true) {
            boolean duplication = false;
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i) == list.get(i - 1)) {
                    list.remove(i);
                    list.remove(i - 1);
                    duplication = true;
                }
            }
            if(!duplication) break;
        }
        return convertArrayListToString(list);
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
