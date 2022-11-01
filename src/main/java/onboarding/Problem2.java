package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int i = 0 ;

        while (i <= cryptogram.length() - 1) {
            if (answer.length() == 0) {
                answer += cryptogram.charAt(i);
            } else {
                if (answer.charAt(answer.length() - 1) == cryptogram.charAt(i)) {
                    if (answer.length() == 1) {
                        answer = "";
                    } else {
                        answer = answer.substring(0, answer.length() - 1);
                    }
                } else {
                    answer += cryptogram.charAt(i);
                }
            }
            i += 1;
        }
        return answer;
    }
}
