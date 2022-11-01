package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getPageNumberSum(Integer pageNumber){
        int ret = 0;
        while(pageNumber>0){
            ret += pageNumber%10;
            pageNumber/= 10;
        }
        return ret;
    }

}