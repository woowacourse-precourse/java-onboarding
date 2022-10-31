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

    static int FindMaxValue(int num){
        int MaxValue = 0;
        int sum = 0;
        int multiple = 1;

        for(int i=0;i<FindDigitByPage(num).size();i++){
            sum += FindDigitByPage(num).get(i);
            multiple *= FindDigitByPage(num).get(i);
        }

        MaxValue = Math.max(sum, multiple);

        return MaxValue;
    }
}

