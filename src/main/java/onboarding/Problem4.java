package onboarding;

public class Problem4 {
    private static char convertChar(char c) { // ASCII 코드를 이용해 문자 변환
        if(c >= 65 && c <= 90) // 대문자의 경우
            return (char)(155 - c);
        else if(c >= 97 && c <= 122) // 소문자의 경우
            return (char)(219 - c);
        else
            return c;
    }

    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++) {
            answer = answer + convertChar(word.charAt(i));
        }
        return answer;
    }
}
