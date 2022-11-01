package onboarding;

import java.util.*;

class Problem1 {
    public static int pageSum(int page) {
        int res = (int)(page/100) + (int)(page/10) + ((page%100)%10);
        return res;
    }
    public static int pageMul(int page) {
        int res = (int)(page/100) * (int)(page/10) * ((page%100)%10);
        return res;
    }
    public static int setScore(int sumScore, int mulScore) {
        int res = sumScore >= mulScore ? sumScore : mulScore;
        return res;
    }
    public static int setError(int page1, int page2) {
        if(page1 - page2 != 1) { return -1; }
        if(page1 > 400 || page2 > 400) { return -1; }
        if(page1 < 1 || page2 < 1) { return -1; }
        if(page1 == page2) { return -1; }
        if(page1 % 2 == 0) { return -1; }
        if(page2 % 2 == 1) { return -1; }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}