package onboarding;

import java.util.*;

public class Problem4 {
    public static Map<Character, Character> alphabetMap = new HashMap<>();
    public static List<Character> motherWord = new ArrayList<>();
    public static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String DELIMITER = UPPERCASE_ALPHABET + LOWERCASE_ALPHABET + " ";
    public static final int indexStart = 0;
    public static final int indexEnd = 26;
    public static int upperCaseA = 65;
    public static int upperCaseZ = 90;
    public static int lowerCaseA = 97;
    public static int lowerCaseZ = 122;

    public static String solution(String word) {
        String answer = "";

        makeFrogDictionary();
        letterInList(word);
        answer = reverseWord();

        return answer;
    }

    public static String reverseWord() {
        String reverseResult = "";

        for (Character letter : motherWord) {
            int letterToInt = (int)letter;

            if (isAlphabet(letterToInt)) {
                reverseResult += alphabetMap.get(letter);
            } else {
                reverseResult += letter;
            }
        }
        return reverseResult;
    }

    public static boolean isAlphabet(int letterToInt) {
        if (letterToInt >= upperCaseA && letterToInt <= lowerCaseZ) {
            return true;
        }
        return false;
    }

    public static void letterInList(String word) {
        StringTokenizer st = new StringTokenizer(word, DELIMITER, true);

        for (int index = indexStart; index < word.length(); index++) {
            String str = st.nextToken();
            motherWord.add(str.charAt(0));
        }
    }

    public static void makeFrogDictionary() {
        AddUpperCaseLetter();
        AddLowerCaseLetter();
    }

    public static void AddLowerCaseLetter() {
        for (int index = indexStart; index < indexEnd; index++) {
            alphabetMap.put((char) (lowerCaseA + index), (char) (lowerCaseZ - index));
        }
    }

    public static void AddUpperCaseLetter() {
        for (int index = indexStart; index < indexEnd; index++) {
            alphabetMap.put((char) (upperCaseA + index), (char) (upperCaseZ - index));
        }
    }
}
