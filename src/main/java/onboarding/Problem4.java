package onboarding;

import ExceptionValidation.P4ExceptionValidation;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {

        if(!(P4ExceptionValidation.p4ExceptionValidation(word))){
            return "";
        }
    }


    public static String findReverseWord(String word) {

        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch, (char) (155 - ch));
            map.put((char) (ch + 32), (char) (187 - ch));
        }
    }


}
