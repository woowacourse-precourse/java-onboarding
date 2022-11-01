package onboarding;

import onboarding.feature2.CryptogramSolver;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = CryptogramSolver.analyzeCryptogram(cryptogram);
        return answer;
    }
}
