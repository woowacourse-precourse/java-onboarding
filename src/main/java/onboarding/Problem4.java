package onboarding;
/*
기능 구현 사항
1. 알파벳을 아스키 코드로 변환
2. 아스키 코드로 대문자, 소문자 구분
3. 배열 인덱스로 접근하여 값 변경
 */
public class Problem4 {
    private static final int DICTIONARY_SIZE = 26;
    private static final int UPPER_CASE_ASCII_CODE = 65;
    private static final int LOWER_CASE_ASCII_CODE = 97;

    public static String solution(String word) {
        int[] dictionary = new int[DICTIONARY_SIZE];
        for(int i = 0; i<dictionary.length; i++) {
            dictionary[i] = DICTIONARY_SIZE - i - 1;
        }
        String answer = makeReverseWord(word, dictionary);
        return answer;
    }

    private static String makeReverseWord(String word, int[] dictionary) {
        String result = "";
        for(int i = 0; i<word.length(); i++) {
            char letter = word.charAt(i);
            if(!isAlphabet(letter)) {
                result += letter;
                continue;
            }
            int dictionaryIndex = convertAlphabetToInt(letter);
            System.out.println((char)(dictionary[dictionaryIndex] + UPPER_CASE_ASCII_CODE));
            if(isUpperCase(letter)) {
                result += (char)(dictionary[dictionaryIndex] + UPPER_CASE_ASCII_CODE);
            }
            if(isLowerCase(letter)) {
                result += (char)(dictionary[dictionaryIndex] + LOWER_CASE_ASCII_CODE);
            }
        }
        return result;
    }

    private static int convertAlphabetToInt(char alphabet) {
        if(isUpperCase(alphabet)) {
            return alphabet - UPPER_CASE_ASCII_CODE;
        }
        return alphabet - LOWER_CASE_ASCII_CODE;
    }

    private static boolean isUpperCase(char alphabet) {
        if(alphabet >= 'A' && alphabet <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowerCase(char alphabet) {
        if(alphabet >= 'a' && alphabet <= 'z') {
            return true;
        }
        return false;
    }

    private static boolean isAlphabet(char word) {
        if (isLowerCase(word) || isUpperCase(word)) {
            return true;
        }
        return false;
    }

}
