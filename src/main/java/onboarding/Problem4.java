package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> convertMap = new HashMap<>();

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        if (isNotInRange(word.length())) {
            return word;
        }

        char[] frogWords = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S',
                'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H',
                'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        convertMap = makeMap(frogWords);

        char[] wordArray = word.toCharArray();
        for (char oneWord : wordArray) {
            if (isSpace(oneWord)) {
                answer.append(oneWord);
                continue;
            }

            char changedWord = convertFrogWord(oneWord);
            answer.append(changedWord);
        }

        return answer.toString();
    }

    private static Map<Character, Character> makeMap(char[] words) {
        Map<Character, Character> convertMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            convertMap.put(words[words.length - 1 - i], words[i]);
        }
        return convertMap;
    }

    private static boolean isUpper(char oneWord) {
        return Character.isUpperCase(oneWord);
    }

    private static boolean isLower(char oneWord) {
        return Character.isLowerCase(oneWord);
    }

    private static boolean isSpace(char oneWord) {
        if (oneWord == ' ') {
            return true;
        }
        return false;
    }

    private static char convertFrogWord(char oneWord) {
        char changedWord = ' ';

        if (isUpper(oneWord)) {
            changedWord = convertMap.get(oneWord);
        } else if (isLower(oneWord)) {
            char upperWord = Character.toUpperCase(oneWord);
            changedWord = Character.toLowerCase(convertMap.get(upperWord));
        } else {
            changedWord = oneWord;
        }

        return changedWord;
    }

    private static boolean isNotInRange(int number) {
        if (number >= 1 && number <= 1000) {
            return false;
        }
        return true;
    }

}