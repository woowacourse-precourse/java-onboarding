package onboarding;


public class Problem4 {
    public static String solution(String word) {
        if (checkValidation(word)) {
            String result = changeWord(word);
            return result;
        }
        return "[ERROR]";
    }
    public static boolean checkValidation(String word) {
        if (word.length() > 1000 || word.length() < 1) {
            return false;
        }
        return true;
    }
    public static char changeAlphabet(char character) {
        if (character < 'a' || character > 'z' || character > 'A' || character > 'Z') {
            return character;
        }
        if (character < 'Z') {
            return (char)('Z' - character + 'A');
        }
        return (char)('z' - character + 'a');
    }
    public static String changeWord(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            char reverseChar = changeAlphabet(word.charAt(i));
            newWord += reverseChar;
        }
        return newWord;
    }
}


/*
1. 입력 조건에 맞지 않는 경우 예외처리 기능
2. 알파벳을 변환하는 기능
- (예외) 알파벳 외의 문자는 변환하지 않음
3. word을 변환하는 기능
* */