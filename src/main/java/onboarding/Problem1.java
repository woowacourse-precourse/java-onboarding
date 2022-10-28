package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        Integer pScore = Math.max(pageScore(breakNum(pobi.get(0))), pageScore(breakNum(pobi.get(1))));
        Integer cScore = Math.max(pageScore(breakNum(crong.get(0))), pageScore(breakNum((crong.get(1)))));

        if(isException(pobi, crong))
            answer = -1;

        else if (pScore.equals(cScore))
            answer = 0;

        else if (pScore > cScore)
            answer = 1;

        else
            answer = 2;

        return answer;
    }

    public static boolean isException(List<Integer> pobi, List<Integer> crong) {

        if(pobi.get(1) == pobi.get(0) + 1 && crong.get(1) == crong.get(0) + 1)
            return false;
        else
            return true;
    }

    public static List<Integer> breakNum(Integer page) {

        List<Integer> broken = new ArrayList<>();

        while(page > 0) {
            broken.add(page % 10);
            page /= 10;
        }

        return broken;
    }

    public static Integer pageScore(List<Integer> broken) {

        Integer sum = 0;
        Integer product = 1;

        for (Integer i : broken) {
            sum += i;
            product *= i;
        }

        return Math.max(sum, product);
    }

}