package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getAnswer(getMaxValue(pobi), getMaxValue(crong));
        return answer;
    }

    private static Integer getMaxValue(List<Integer> pages) {
        List<Integer> leftPageEachNumbers = getEachNumbers(pages.get(0));
        int leftPageMaxValue = Math.max(doSum(leftPageEachNumbers), doMultiply(leftPageEachNumbers));

        List<Integer> rightPageEachNumbers = getEachNumbers(pages.get(1));
        int rightPageMaxValue = Math.max(doSum(rightPageEachNumbers), doMultiply(rightPageEachNumbers));

        return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    private static List<Integer> getEachNumbers(Integer integer) {
        List<Integer> valueList = new ArrayList<>();
        int loopTimes = integer.toString().length();
        for (int i = 0; i < loopTimes; i++) {
            valueList.add(integer % 10);
            integer /= 10;
        }
        return valueList;
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
        return (x < y) ? 2 : ((x == y) ? 0 : 1);
    }




}