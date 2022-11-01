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
}

