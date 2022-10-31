package onboarding;

import java.util.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    static List<Integer> FindDigitByPage(int PageNumber){ //각 자리수 구하기

        List<Integer> DigitList = new ArrayList<Integer>();

        int number = PageNumber;

        while(number!=0){
            DigitList.add(number%10);
            number = number/10;
        }

        return DigitList;
    }


}

