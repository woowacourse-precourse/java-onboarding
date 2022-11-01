package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static void main(String[] args) {
        String word = "I love you";
        System.out.printf("%-30s|%-30s|", "word", "result");
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.printf("%-30s|%-30s|", "\"" + word + "\"", "\"" + solution(word) + "\"");
    }

    public static String solution(String word) {
        String answer = "";
        List<Character> letters = new ArrayList<>();
        Word.validate(word);
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

    private static class Word {
        private static final int MIN_WORD_LENGTH = 1;
        private static final int MAX_WORD_LENGTH = 1000;

        public static void validate(String word) {
            if (checkLengthOfWord(word)) {
                throw new IllegalArgumentException(
                    "The word's length should be greater than or equal to 1, and less than or equal to 1,000.");
            }
        }

        private static boolean checkLengthOfWord(String word) {
            return word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH;
        }
    }
}