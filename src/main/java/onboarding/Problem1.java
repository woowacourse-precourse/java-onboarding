package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * pageNumber의 각 자릿수의 합을 반환
     * */
    public static int getPageNumberSum(Integer pageNumber){
        int ret = 0;
        while(pageNumber>0){
            ret += pageNumber%10;
            pageNumber/= 10;
        }
        return ret;
    }

    /**
     * pageNumber의 각 자릿수들의 곱을 반환
     */
    public static int getPageNumberMul(Integer pageNumber){
        int ret = 1;
        while(pageNumber>0){
            ret *= pageNumber%10;
            pageNumber/=10;
        }
        return ret;
    }

}