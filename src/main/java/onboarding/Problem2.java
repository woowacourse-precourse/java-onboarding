package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        for(char c : cryptogram.toCharArray()) {
            if(answer.isEmpty() || !answer.endsWith(String.valueOf(c))) {
                answer += c;
                continue;
            }

            answer = answer.substring(0, answer.length() - 1);
        }

        return answer;
    }
}
