package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 65 - 90 (A ~ Z)
        // 97 - 122 (a ~ z)
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' ') answer += String.valueOf(c);

            int idx = (int) c;
            if(idx >= 65 && idx <= 90) answer += String.valueOf((char) (90 - idx + 65));
            if(idx >= 97 && idx <= 122) answer += String.valueOf((char) (122 - idx + 97));
        }

        return answer;
    }
}
