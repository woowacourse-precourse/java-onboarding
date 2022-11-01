package onboarding;

public class Problem4 {
    public static String solution(String word) {


        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if ((int)word.charAt(i) >= 65 && (int)word.charAt(i) <= 90) {
                answer += (char)(155 - (int)word.charAt(i));
            } else if ((int)word.charAt(i) >= 97 && (int)word.charAt(i) <= 122) {
                answer += (char)(219 - (int)word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}

