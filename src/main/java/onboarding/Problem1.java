package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!exceptionCheck(pobi) || !exceptionCheck(crong)){return -1;}

        int pobi_score = getScore(pobi);
        int crong_score = getScore(crong);

        return answer;
    }
    static int getScore(List<Integer> list) {
        int left_page = list.get(0);
        int right_page = list.get(1);
        int score = Math.max(calculateSum(left_page),calculateSum(right_page));
        score = Math.max(score,calculateMulti(left_page));
        score = Math.max(score,calculateMulti(right_page));
        return score;
    }
    static boolean exceptionCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) {return false;}
        if(left%2 == 0) {return false;}
        if(left < 1 || left > 400) {return false;}
        if(right <1 || right > 400) {return false;}
        return true;
    }
}