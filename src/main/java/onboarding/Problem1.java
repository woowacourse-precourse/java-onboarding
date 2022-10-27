package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int left_max_pobi=divideNum(pobi.get(0));
        int right_max_pobi=divideNum(pobi.get(1));

        int left_max_crong=divideNum(crong.get(0));
        int right_max_crong=divideNum(crong.get(1));

        

        return answer;
    }

    public static int divideNum(Integer x){ // 각 자릿수 별로 나누고, 더한것이 가장 큰지 곱한 것이 가장 큰지 비교
        int addSum=0;
        int mulSum=1;
        while(x>0){
            addSum+=x%10;
            mulSum*=x%10;
            x/=10;
        }

        int max= Math.max(addSum, mulSum);
        return max;
    }



}