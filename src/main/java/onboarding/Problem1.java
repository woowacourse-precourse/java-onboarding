package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getAnswer(getMaxValue(pobi), getMaxValue(crong));
        return answer;
    }

    private static Integer getMaxValue(List<Integer> pages) {

        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        if ((leftPage + 1) != rightPage) {
            return -1;
        }

        int leftPageMaxValue = doCalculate(leftPage);
        int rightPageMaxValue = doCalculate(rightPage);

        return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    private static int doCalculate(Integer page) {
        List<Integer> eachNumbers = getEachNumbers(page);
        int pageMaxValue = Math.max(doSum(eachNumbers), doMultiply(eachNumbers));
        return pageMaxValue;
    }

    private static List<Integer> getEachNumbers(Integer page) {
        List<Integer> eachNumbers = new ArrayList<>();
        int loopTimes = page.toString().length();
        for (int i = 0; i < loopTimes; i++) {
            eachNumbers.add(page % 10);
            page /= 10;
        }
        return eachNumbers;
    }

    private static Integer doSum(List<Integer> eachNumbers) {
        int value = 0;
        for (Integer eachNumber : eachNumbers) {
            value += eachNumber;
        }
        return value;
    }

    private static Integer doMultiply(List<Integer> EachNumbers) {
        int value = 1;
        for (Integer eachNumber : EachNumbers) {
            value *= eachNumber;
        }
        return value;
    }


    private static int getAnswer(Integer x, Integer y) {
        if (x == -1 || y == -1) {
            return -1;
        }
        return (x < y) ? 2 : ((x == y) ? 0 : 1);
    }




}