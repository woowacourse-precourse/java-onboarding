package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getMaxScore(pobi.get(0), pobi.get(1));
        int crongScore = getMaxScore(pobi.get(0), pobi.get(1));

        return answer;

    }

    public static int getMaxScore(int left, int right) { // 곱한값과 더한값 중 더 큰 값 가져오는 기능
        if(!isValidate(left, right)) {
            return -1;
        }

        return Math.max(score(left, right));
    }
    public static boolean isValidate(int left, int right) {
        if(left % 2 == 1 && right % 2 == 0 && left + 1 == right) return true;
        else return false;
    }

    public static int score(int left, int right) {

    }
}