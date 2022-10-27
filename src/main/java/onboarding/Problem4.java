package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static List<Character> characterList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }

    public static String solution(String word) {
        return converterAlphabet(word);
    }

    private static String converterAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);

            if (65 <= alphabet && alphabet <= 90) {
                converterUpperAlphabet(alphabet);
            } else if (97 <= alphabet && alphabet <= 122) {
                converterLowAlphabet(alphabet);
            } else {
                characterList.add(alphabet);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char alphabet : characterList) {
            sb.append(alphabet);
        }

        return sb.toString();
    }

    private static void converterUpperAlphabet(char alphabet) {
        int alphabetInterval = 27;

        if (alphabet < 'M') {
            for (int j = 'A'; j <= alphabet; j++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;

        } else {
            for (int j = 'Z'; j >= alphabet; j--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }

    private static void converterLowAlphabet(char alphabet) {
        int alphabetInterval = 27;

        if (alphabet < 'm') {
            for (int j = 'a'; j <= alphabet; j++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;

        } else {
            for (int j = 'z'; j >= alphabet; j--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }
}
