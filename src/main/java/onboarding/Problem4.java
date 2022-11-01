package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int alphabet, ascii, reverseAlphabet;
        alphabet = ascii = reverseAlphabet = 0;

        for (int i=0; i < word.length(); i++) {
            // 1. 문자가 대문자일 경우, 아스키코드값을 65로 설정.
            if (Character.isUpperCase(word.charAt(i))) {
                ascii = 65;
            }
        }
        return answer;
    }
}
