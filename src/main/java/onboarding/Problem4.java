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
                // 2. 문자가 소문자일 경우, 아스키코드값을 97로 설정.
            } else if (Character.isLowerCase(word.charAt(i))) {
                ascii = 97;
                // 3. 알바벳 외의 문자는 빈칸으로 설정.
            } else {
                answer += ' ';
                continue;
            }
            // 4. 변환된 알파벳으로 반환.
            alphabet = (int)word.charAt(i)-ascii;
            reverseAlphabet = ascii + 25 - alphabet;
            answer += String.valueOf((char) reverseAlphabet);
        }
        return answer;
    }
}
