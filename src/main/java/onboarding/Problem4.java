package onboarding;

import onboarding.problem4.NotWantedCharacter;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        ArrayList<Character> upperDictionary = new ArrayList<>();
        ArrayList<Character> lowerDictionary = new ArrayList<>();
        saveFrogDictionary(upperDictionary, lowerDictionary);
        answer = getAnswer(word, answer, upperDictionary, lowerDictionary);
        return answer;
    }

    //2.  주어진 word 청개구리 사전에 맞춰서 변환
    private static String getAnswer(String word, String answer, ArrayList<Character> upperDictionary, ArrayList<Character> lowerDictionary) {
        for (int i = 0; i < word.length(); i++) {
            char characterBeforeConversion = word.charAt(i);
            answer = getUpperCase(word, answer, upperDictionary, i, characterBeforeConversion);
            answer = getLowerCase(word, answer, lowerDictionary, i, characterBeforeConversion);
            answer = getBlank(answer, characterBeforeConversion);
            checkException(characterBeforeConversion);
        }
        return answer;
    }

    // 예외사항 변환할 수 있는 문자인지 체크
    private static void checkException(char characterBeforeConversion) {
        if(!isLowerCase(characterBeforeConversion) && !isUpperCase(characterBeforeConversion) && !isBlank(characterBeforeConversion)){
            throw new NotWantedCharacter(characterBeforeConversion + "은 변환되지 않는 문자입니다.");
        }
    }

    private static String getBlank(String answer, char characterBeforeConversion) {
        if(isBlank(characterBeforeConversion)){
            answer +=' ';
        }
        return answer;
    }

    private static String getLowerCase(String word, String answer, ArrayList<Character> lowerDictionary, int i, char characterBeforeConversion) {
        if(isLowerCase(characterBeforeConversion)) {
            answer += lowerDictionary.get((int) (word.charAt(i) - 'a'));
        }
        return answer;
    }

    private static String getUpperCase(String word, String answer, ArrayList<Character> upperDictionary, int i, char characterBeforeConversion) {
        if(isUpperCase(characterBeforeConversion)) {
            answer += upperDictionary.get((int) (word.charAt(i) - 'A'));
        }
        return answer;
    }

    // 1. 배열에 청개구리 사전 저장
    private static void saveFrogDictionary(ArrayList<Character> upperDictionary, ArrayList<Character> lowerDictionary) {
        for (int i = 0; i < 26; i++) {
            upperDictionary.add((char) ('Z'-i));
            lowerDictionary.add((char) ('z' - i));
        }
    }

    private static boolean isBlank(char characterBeforeConversion) {
        return characterBeforeConversion == ' ';
    }

    private static boolean isLowerCase(char characterBeforeConversion) {
        return Character.isLowerCase(characterBeforeConversion);
    }

    private static boolean isUpperCase(char characterBeforeConversion) {
        return Character.isUpperCase(characterBeforeConversion);
    }
}
