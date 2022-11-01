package onboarding;

import onboarding.problem2.Cryptogram;
import onboarding.problem2.CryptogramSolver;

public class Problem2 {
    public static String solution(String message) {
        Cryptogram cryptogram = new Cryptogram(message);
        CryptogramSolver solver = new CryptogramSolver();

        return solver.solve(cryptogram);
    }
}
