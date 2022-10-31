package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getMaxScore(pobi.get(0), pobi.get(1));
        int crongScore = getMaxScore(pobi.get(0), pobi.get(1));

        return answer;

    }

    public static int getMaxScore(int left, int right) { //
        if(!isValidate(left, right)) {
            return -1;
        }

        return Math.max(score(left, right));
    }

}