package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int cur = 1;
        int prior = 0;

        while (answer.length() > 0 && cur < answer.length()) {
            if (answer.charAt(cur) == answer.charAt(prior)) {
                char target = answer.charAt(prior);
                for (cur = cur + 1; cur < answer.length(); cur++)
                    if (target != answer.charAt(cur)) break;
                answer = answer.substring(0, prior) + answer.substring(cur);
                cur = 0;
            }
            prior = cur;
            cur++;
        }
        return answer;
    }
}
