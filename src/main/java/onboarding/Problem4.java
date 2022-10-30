package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> letters = new ArrayList<>();
        splitWord(word, letters);
        letters = replaceLetters(letters);
        answer = combineLetter(letters);
        return answer;
    }

    private static String combineLetter(List<Character> letters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character letter : letters) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    private static List<Character> replaceLetters(List<Character> letters) {
        return letters.stream().map(letter -> {
            if (Character.isUpperCase(letter)) {
                letter = convertForUpperCaseLetter(letter);
            }
            if (Character.isLowerCase(letter)) {
                letter = convertForLowerCaseLetter(letter);
            }
            return letter;
        }).collect(Collectors.toList());
    }

    private static Character convertForUpperCaseLetter(Character letter) {
        return (char) ('A' + 'Z' - letter);
    }

    private static Character convertForLowerCaseLetter(Character letter) {
        return (char) ('a' + 'z' - letter);
    }

    private static List<Character> splitWord(String word, List<Character> letters) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            letters.add(aChar);
        }
        return letters;
    }
}