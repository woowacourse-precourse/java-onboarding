package onboarding;

import java.util.List;
import onboarding.solution1.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        ScoreCalculator score = new ScoreCalculator();
        IsException exception = new IsException();
        CompareScore compare = new CompareScore();
        if (exception.isException(pobi) == 0 && exception.isException(crong) == 0){
            int resPobi = score.findScore(pobi);
            int resCrong = score.findScore(crong);
            int answer = compare.compareRes(resPobi, resCrong);
            return answer;
        }
        return -1;
    }
}