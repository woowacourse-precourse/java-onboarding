package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int sumPageEachDigitNum(Integer pageNum) {
        int eachDigitNumSum = 0;
        while(pageNum != 0) {
            eachDigitNumSum += pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumSum;
    }

    public int multiplyPageEachDigitNum(Integer pageNum) {
        int eachDigitNumMultiplication = 1;
        while(pageNum != 0) {
            eachDigitNumMultiplication *= pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumMultiplication;
    }

    public int returnLargerOne(Integer comparisonNum1, Integer comparisonNum2) {
        int largerNum = 0;
        if(comparisonNum1 >= comparisonNum2) largerNum = comparisonNum1;
        if(comparisonNum1 < comparisonNum2) largerNum = comparisonNum1;
        return largerNum;
    }
}