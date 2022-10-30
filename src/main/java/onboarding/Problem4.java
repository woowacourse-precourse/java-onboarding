package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = reverseWord(word);
        return answer;
    }
    public static String reverseWord(String word) {

        String result = "";

        ArrayList<Character> input = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            input.add(word.charAt(i));
        }

        ArrayList<String> bAlphabet = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        ArrayList<String> sAlphabet = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        for (int i = 0; i <= word.length() - 1; i++) {

            if (!bAlphabet.contains(input.get(i).toString()) && !sAlphabet.contains(input.get(i).toString())) {
                result += input.get(i);
            }

            for (int j = 0; j < bAlphabet.size(); j++) {
                if (bAlphabet.get(j).equals(input.get(i).toString())) {
                    result += bAlphabet.get(25-j);
                } else if (sAlphabet.get(j).equals(input.get(i).toString())) {
                    result += sAlphabet.get(25-j);
                }
            }
        }
        return result;
    }
}
