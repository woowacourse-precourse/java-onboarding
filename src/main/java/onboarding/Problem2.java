package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        for (int i=1; i<answer.length();i++){
            if (answer.charAt(i-1) == answer.charAt(i)) {
                answer = answer.substring(0, i-1) + answer.substring(i+1);
                i = 0;
            }
        }

        return answer;
    }
}
