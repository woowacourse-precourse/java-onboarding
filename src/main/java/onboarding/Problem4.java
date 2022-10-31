package onboarding;

public class Problem4 {

    static char[] upperCaseList = new char[26];
    static char[] lowerCaseList = new char[26];
    public static String solution(String word) {
        for (int i=0; i<26; i++) {
            upperCaseList[i] = (char)(i+65);
            lowerCaseList[i] = (char)(i+97);
        }
        return changeWord(word);
    }

    private static String changeWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); i++) {
            char changedAlphabet = changeAlphabet(word.charAt(i));
            sb.append(changedAlphabet);
        }
        return sb.toString();
    }

    private static char changeAlphabet(char alphabet) {
        if (alphabet >= 97 && alphabet <= 122) { // 소문자 처리
            return changeLowerCase(alphabet);
        }
        if (alphabet >= 65 && alphabet <= 90) { // 대문자 처리
            return changeUpperCase(alphabet);
        }
        return alphabet; // 일반 문자 공백 포함
    }

    private static char changeUpperCase(char alphabet) {
        int index = alphabet - 'A';
        return upperCaseList[25-index];
    }

    private static char changeLowerCase(char alphabet) {
        int index = alphabet - 'a';
        return lowerCaseList[25-index];
    }
}

