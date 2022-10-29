package onboarding;

import java.util.*;

public class Problem2 {
    public static Stack<Character> st= new Stack<>();
    public static StringBuilder answer;

    public static String solution(String cryptogram) {
        answer = new StringBuilder();

        return answer.toString();
    }

    public static Set<Character> createCharactersSet(String cryptogram) {
        Set<Character> charactersSet = new LinkedHashSet<>();

        for (char c : cryptogram.toCharArray()) {
            charactersSet.add(c);
        }

        return charactersSet;
    }
}
