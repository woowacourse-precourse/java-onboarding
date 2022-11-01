package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int i = 0;
        while(i + 1 < answer.length()) {
            if(answer.charAt(i) == answer.charAt(i + 1)) {
                if(i == answer.length() - 2)
                    answer = answer.substring(0, i);
                else
                    answer = answer.substring(0, i) + answer.substring(i + 2);
                i = 0;
            } else i++;
        }
        return answer;
    }
}