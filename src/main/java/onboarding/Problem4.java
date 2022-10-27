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
        reverseWord(word);

        return answer;
    }

    private static void reverseWord(String word) {
        wordInList(word);
        String reverseWord = "";

        for (Character letter : motherWord) {
        }
    }

    public static boolean isUpperCaseLetter(Character letter) {
        if ((letter - '0') >= upperCaseA && (letter - '0') <= upperCaseZ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLowerCaseLetter(Character letter) {
        if ((letter - '0') >= lowerCaseA && (letter - '0') <= lowerCaseZ) {
            return true;
        } else {
            return false;
        }
    }

    private static void wordInList(String word) {
        motherWord = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(word, UPPERCASE_ALPHABET + LOWERCASE_ALPHABET, true);

        for (int index = indexStart; index < word.length(); index++) {
            motherWord.add(st.nextToken().charAt(index));
        }
    }

    public static void makeFrogDictionary() {
        upperCase = new HashMap<Character, Character>();
        lowerCase = new HashMap<Character, Character>();

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
