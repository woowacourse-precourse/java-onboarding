package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        return answer;
    }

    //예외 체크
    private static int exceptionCheck(String strLeft, String strRight){
        int left = Integer.parseInt(strLeft);
        int right = Integer.parseInt(strRight);

        //첫 페이지, 마지막 페이지 x
        if(left == 0 || right == 400)
            return 1;

        //두 페이지의 차이가 1보다 크면 안됨
        if(right - left > 1)
            return 1;

        return 0;
    }
    public static int getMaxBetweenSumAndMultiply(String str){
        int sum = 0, mul = 1;
        int [] arry = new int[str.length()];

        //한자리씩 int형으로 분해
        for(int i = 0; i < str.length(); i++){
            arry[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for(int j = 0 ; j < str.length(); j++){
            sum += arry[j];
            mul *= arry[j];
        }

        if(sum > mul)
            return sum;
        else
            return mul;
    }
    public static int getWinner(int pobiScore,int crongScore){
        int answer = 0;
        if(pobiScore > crongScore)
            answer = 1;
        else if (pobiScore < crongScore)
            answer = 2;
        else
            answer = 0;
        return answer;
    }
}

