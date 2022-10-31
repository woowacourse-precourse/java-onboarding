package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getMaxScore(pobi.get(0), pobi.get(1));
        int crongScore = getMaxScore(crong.get(0), crong.get(1));

        if(pobiScore == -1 || crongScore == -1) {
            answer = -1;
        }else if(pobiScore > crongScore) {
            answer = 1;
        }else if(pobiScore < crongScore) {
            answer = 2;
        }else {
            answer = 0;
        }
        return answer;

    }

    public static int getMaxScore(int left, int right) { // 곱한값과 더한값 중 더 큰 값 가져오는 기능
        if(!isValidate(left, right)) {
            return -1;
        }

        return Math.max(score(left), score(right));
    }
    public static boolean isValidate(int left, int right) {
        if(left % 2 == 1 && right % 2 == 0 && left + 1 == right) return true;
        else return false;
    }

    public static int score(int page) {
        int plus = 0;
        int mul = 1;

        while(page > 0) {
            plus += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        return Math.max(plus, mul);
    }
}