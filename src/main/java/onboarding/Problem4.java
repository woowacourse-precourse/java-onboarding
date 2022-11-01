package onboarding;

import ExceptionValidation.P4ExceptionValidation;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {

        if(!(P4ExceptionValidation.p4ExceptionValidation(word))){
            return "";
        }
        String reverseWord = findReverseWord(word);

        return reverseWord;
    }


    public static String findReverseWord(String word) {

        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch, (char) (155 - ch));
            map.put((char) (ch + 32), (char) (187 - ch));
        }

        for (int i = 0; i < word.length(); i++) {

            String s = word.substring(i, i + 1);

            if (s.equals(" ")) {
                builder.append(" ");
            } else {
                builder.append(map.get(s.charAt(0)));
            }
        }

        return builder.toString();
    }


}
