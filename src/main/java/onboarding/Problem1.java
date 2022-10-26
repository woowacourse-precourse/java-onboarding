package onboarding;

import onboarding.problem1.Judgment;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Judgment judgment = new Judgment();

        if (judgment.verification(pobi, crong) == 0) {
            int answer = judgment.compare(pobi, crong);
            return answer;
        }

        return -1;
    }
}