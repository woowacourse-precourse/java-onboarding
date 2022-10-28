package onboarding;

import java.util.*;

public class Problem4 {
    public static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String DELIMITER = UPPERCASE_ALPHABET + LOWERCASE_ALPHABET + " ";
    public static final String INIT_STRING = "";
    public static final int indexStart = 0;
    public static final int indexEnd = 26;
    public static int upperCaseA = 65;
    public static int upperCaseZ = 90;
    public static int lowerCaseA = 97;
    public static int lowerCaseZ = 122;


    public static String solution(String word) {
        Map<Character, Character> alphabetMap = new HashMap<>();
        List<Character> motherWord = new ArrayList<>();

        makeFrogDictionary(alphabetMap);
        separateLetter(word, motherWord);
        String answer = reverseWord(alphabetMap, motherWord);

        return answer;
    }

    public static String reverseWord(Map<Character, Character> alphabetMap, List<Character> motherWord) {
        String reverseResult = INIT_STRING;

        for (Character letter : motherWord) {
            reverseResult += (isAlphabet((int) letter)) ? alphabetMap.get(letter) : letter;
        }
        return reverseResult;
    }

    public static boolean isAlphabet(int letterToInt) {
        if (letterToInt >= upperCaseA && letterToInt <= lowerCaseZ) {
            return true;
        }
        return false;
    }

    public static void separateLetter(String word, List<Character> motherWord) {
        StringTokenizer st = new StringTokenizer(word, DELIMITER, true);

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            addMotherLetter(motherWord, str.charAt(0));
        }
    }

    public static void addMotherLetter(List<Character> motherWord, char letter) {
        motherWord.add(letter);
    }

    public static void makeFrogDictionary(Map<Character, Character> alphabetMap) {
        for (int index = indexStart; index < indexEnd; index++) {
            addLowerCase(alphabetMap,index);
            addUpperCase(alphabetMap,index);
        }
    }

    public static void addUpperCase(Map<Character, Character> alphabetMap, int index) {
        alphabetMap.put((char) (upperCaseA + index), (char) (upperCaseZ - index));
    }

    public static void addLowerCase(Map<Character, Character> alphabetMap, int index) {
        alphabetMap.put((char) (lowerCaseA + index), (char) (lowerCaseZ - index));
    }
}
