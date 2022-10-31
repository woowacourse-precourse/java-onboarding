package onboarding;

/*
* 기능 목록
* 1. 알파벳 변환
* 2. 전체 문장 변환
* */
public class Problem4 {

    // 알파벳 변환
    public static char reverseChar(char c) {
        // 알파벳인 경우에만 변환
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        int capitalTotal = 'A' + 'Z';
        int total = 'a' + 'z';

        if (Character.isUpperCase(c)) {
            return (char) (capitalTotal - c);
        } else {
            return (char) (total - c);
        }
    }
    // 전체 문장 변환
    public static String reverseWord(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += reverseChar(word.charAt(i));
        }
        return answer;
    }

    public static String solution(String word) {
        return reverseWord(word);
    }


}
