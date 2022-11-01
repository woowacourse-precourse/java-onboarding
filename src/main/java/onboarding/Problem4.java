package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {
    public static final ArrayList<Character> dic =
            new ArrayList<>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for(Character letter : word.toCharArray()){
            if(Character.isAlphabetic(letter)) {
                sb.append(encryption(letter));
            } else
                sb.append(letter);
        }
        return sb.toString();
    }

    public static Character encryption(Character letter) {
        if(Character.isLowerCase(letter)){
            return Character.toLowerCase(dic.get(25 - dic.indexOf(Character.toUpperCase(letter))));
        } else
            return dic.get(25 - dic.indexOf(letter));
    }
}
