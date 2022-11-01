package onboarding;

import java.util.List;

import static java.lang.Math.max;

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

    /**
     * 왼쪽 페이지와 오른쪽 페이지의 각 자리 숫자들의 합과 곱들을 얻고, 그 중 가장 큰 값을 반환
     * @param pages 왼쪽 페이지와 오른쪽 페이지의 숫자가 담긴 리스트
     */
    public static int getMaxNumber(List<Integer> pages){
        int MaxNumber = 0;
        for(Integer pageNumber : pages){
            int sum = getPageNumberSum(pageNumber);
            int mul = getPageNumberMul(pageNumber);
            MaxNumber = max(MaxNumber, sum);
            MaxNumber = max(MaxNumber, mul);
        }
        return MaxNumber;
    }

}