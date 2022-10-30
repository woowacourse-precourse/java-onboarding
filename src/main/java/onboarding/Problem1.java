package onboarding;

import java.util.*;

class Problem1 {

    private static int secondSum=0,secondMul=0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int firstUserScore = Math.max(numMaxSumMul(pobi.get(0)),numMaxSumMul(pobi.get(1)));
        int SecondUserScore = Math.max(numMaxSumMul(crong.get(0)),numMaxSumMul(crong.get(1)));

        return answer;
    }
    public static int numMaxSumMul(int page){
        int sum=0, mul=1;
        while (page>0){
            sum += page%10;
            mul *= page%10;
            page /= 10;
        }
        return Math.max(sum,mul);
    }
}