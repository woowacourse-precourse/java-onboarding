package onboarding;

import onboarding.problem2.*;
public class Problem2 {
    public static String solution(String cryptogram) {
        Cryptogram solver = new Cryptogram(cryptogram);
        boolean keep = true;
        while (keep) {
            keep = solver.remove();
        }
        String answer = solver.toString();
        return answer;
    }
}
