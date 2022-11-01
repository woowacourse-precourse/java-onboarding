package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<Object> wordList = getAsciiList(word);

        return answer;
    }

    private static ArrayList<Object> getAsciiList(String word) {
        char[] ch = word.toCharArray();
        ArrayList<Integer> asciiList = new ArrayList<>();
        for (char c : ch) {
            asciiList.add((int) c);
        }
        return asciiList;
    }

}
