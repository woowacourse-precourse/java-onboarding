package onboarding;

public class Problem4 {
    /*
    1. 알파벳인지 검사 후
    2. 알파벳이라면 reversAlphabet() 실행
    3. 알파벳이 아니라면 그대로 StringBuffer에 append
     */
    public static String solution(String word) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c = reverseAlphabet(c);
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }

    // 알파벳을 반대쪽 알파벳으로 변환해주는 함수 reverseAlphabet()
    private static char reverseAlphabet(char c) {
        if (Character.isLowerCase(c)) {
            return (char) ('z' - c + 'a');
        }
        if (Character.isUpperCase(c)) {
            return (char) ('Z' - c + 'A');
        }
        return c;
    }

}
