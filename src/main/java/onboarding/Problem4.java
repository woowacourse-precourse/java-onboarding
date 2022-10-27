package onboarding;

import java.util.*;

public class Problem4 {
    public static Map<Character, Character> upperCase;
    public static Map<Character, Character> lowerCase;
    public static List<Character> motherWord;
    public static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int indexStart = 0;
    public static final int indexEnd = 27;
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
        String reverseWord = "";

        for (Character letter : motherWord) {
            int letterToInt = (int)letter;

            if (isUpperCaseLetter(letterToInt)) {
                reverseWord += upperCase.get(letter);
            } else if (isLowerCaseLetter(letterToInt)) {
                reverseWord += lowerCase.get(letter);
            } else {
                reverseWord += letter;
            }
        }
        return reverseWord;
    }

    public static boolean isUpperCaseLetter(int letterToInt) {
        if (letterToInt >= upperCaseA && letterToInt <= upperCaseZ) {
            return true;
        }
        return false;
    }

    public static boolean isLowerCaseLetter(int letterToInt) {
        if (letterToInt >= lowerCaseA && letterToInt <= lowerCaseZ) {
            return true;
        }
        return false;
    }

    private static void letterInList(String word) {
        motherWord = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(word, UPPERCASE_ALPHABET + LOWERCASE_ALPHABET + " ", true);

        for (int index = indexStart; index < word.length(); index++) {
            String str = st.nextToken();
            motherWord.add(str.charAt(0));
        }
    }

    public static void makeFrogDictionary() {
        upperCase = new HashMap<>();
        lowerCase = new HashMap<>();

        initUpperCaseMap();
        initLowerCaseMap();
    }

    public static void initLowerCaseMap() {
        for (int index = indexStart; index < indexEnd; index++) {
            lowerCase.put((char) (lowerCaseA + index), (char) (lowerCaseZ - index));
        }
    }

    public static void initUpperCaseMap() {
        for (int index = indexStart; index < indexEnd; index++) {
            upperCase.put((char) (upperCaseA + index), (char) (upperCaseZ - index));
        }
    }
}
