package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static Map<Character, Character> upperCase;
    public static Map<Character, Character> lowerCase;
    public static final int indexStart = 0;
    public static final int indexEnd = 27;
    public static int upperCaseA = 65;
    public static int upperCaseZ = 90;
    public static int lowerCaseA = 97;
    public static int lowerCaseZ = 122;

    public static String solution(String word) {
        String answer = "";

        makeFrogDictionary();

        return answer;
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
