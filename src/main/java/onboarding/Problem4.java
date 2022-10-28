package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 65 - 90 (A ~ Z)
        // 97 - 122 (a ~ z)
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' ') answer += String.valueOf(c); // 현재 문자가 공백일 경우

            int idx = (int) c; // 알파벳의 int 값
            if(idx >= 65 && idx <= 90) answer += String.valueOf((char) (90 - idx + 65));   // 현재 문자가 대문자일 경우
            if(idx >= 97 && idx <= 122) answer += String.valueOf((char) (122 - idx + 97)); // 현재 문자가 소문자일 경우
        }

        return answer;
    }
}
