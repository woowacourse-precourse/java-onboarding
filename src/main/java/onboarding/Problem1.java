package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = pobiMax(pobi);
        int crong_max = crongMax(crong);



        return answer;
    }

    public static int pobiMax(List<Integer> pobi){  // pobi의 값중 가장 큰 값 찾기

        int left_max=divideNum(pobi.get(0));
        int right_max=divideNum(pobi.get(1));

        return Math.max(left_max, right_max);
    }

    public static int crongMax(List<Integer> crong){  // crong의 값중 가장 큰 값 찾기
        int left_max=divideNum(crong.get(0));
        int right_max=divideNum(crong.get(1));

        return Math.max(left_max, right_max);
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