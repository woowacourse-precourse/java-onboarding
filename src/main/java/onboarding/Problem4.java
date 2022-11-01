package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<Integer> wordList = getAsciiList(word);
        ArrayList<Integer> reflectedList = reflectList(wordList);
        return answer;
    }

    private static ArrayList<Integer> getAsciiList(String word) {
        char[] ch = word.toCharArray();
        ArrayList<Integer> asciiList = new ArrayList<>();
        for (char c : ch) {
            asciiList.add((int) c);
        }
        return asciiList;
    }

    private static ArrayList<Integer> reflectList(ArrayList<Integer> asciiList) {
        ArrayList<Integer> reflectedList = new ArrayList<>();
        for (Integer i : asciiList) {
            reflectedList.add(reflectAlphabet(i));
        }
    }

    private static int reflectAlphabet(int i) {
        if (65 <= i && 90 >= i) {
            i = 65 + 90 - i;
        }
        if (97 <= i && 122 >= i) {
            i = 97 + 122 - i;
        }
        return i;
    }

}
