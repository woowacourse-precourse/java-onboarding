package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {

        String momWords = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String childWords = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        ArrayList<Integer> indexList = new ArrayList<>();

        String upperWord = word.toUpperCase();
        for (int i = 0; i < upperWord.length(); i++) {
            indexList.add(momWords.indexOf(upperWord.charAt(i)));
        }

        StringBuilder childWord = new StringBuilder();
        for (int idx : indexList) {
            if (idx == -1) {
                childWord.append(" ");
            } else {
                childWord.append(childWords.charAt(idx));
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 97) {
                childWord.setCharAt(i, (char)(childWord.charAt(i)+32));
            }
        }

        return childWord.toString();
    }
}
