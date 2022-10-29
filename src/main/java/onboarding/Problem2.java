package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    public static Set<Character> createCharactersSet(String cryptogram) {
        Set<Character> charactersSet = new LinkedHashSet<>();

        for (char c : cryptogram.toCharArray()) {
            charactersSet.add(c);
        }

        return charactersSet;
    }

    public static String replaceRepeatCharacter(String cryptogram) {
        Set<Character> charactersSet = createCharactersSet(cryptogram);
        for (Character character : charactersSet) {
            cryptogram = cryptogram.replaceAll(character + "{2,}", "");
        }
        return cryptogram;
    }
}
