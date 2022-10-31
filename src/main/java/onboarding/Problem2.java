package onboarding;

import java.util.*;

public class Problem2 {
    private final static int MIN_CRYPTOGRAM_VALUE = 1;
    private final static int MAX_CRYPTOGRAM_VALUE = 1000;

    public static String solution(String cryptogram) {
        if (!isValidCryptogram(cryptogram)) {
            return cryptogram;
        }
        String answer = cryptogram;
        boolean isChange = false;
        while (!isChange) {
            String original = answer;
            answer = replaceRepeatCharacter(original);
            isChange = original.equals(answer);
        }

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

    public static boolean isValidCryptogram(String cryptogram) {
        String cryptogramRegex = "^[a-z]*";
        return cryptogram.matches(cryptogramRegex)
                && cryptogram.length() <= MAX_CRYPTOGRAM_VALUE && cryptogram.length() >= MIN_CRYPTOGRAM_VALUE;
    }
}
