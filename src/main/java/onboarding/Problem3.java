package onboarding;

import onboarding.problem3.SolveGame369;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        SolveGame369 solveGame369 = new SolveGame369();
        if (solveGame369.isFailedInputValidation(number)) throw new IllegalArgumentException();

        answer = solveGame369.count369OfSeparatedNum(number);

        return answer;
    }


}
