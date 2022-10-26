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
        List<Integer> results = new ArrayList<>();
        for (Integer page : pages) {
            List<Integer> eachNumbers = getEachNumbers(page);
            results.add(Math.max(doSum(eachNumbers), doMultiply(eachNumbers)));
        }

        return Collections.max(results);
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

    private static Integer doSum(List<Integer> singleNumbers) {
        int value = 0;
        for (Integer singleNumber : singleNumbers) {
            value += singleNumber;
        }
        return value;
    }

    private static Integer doMultiply(List<Integer> singleNumbers) {
        int value = 1;
        for (Integer singleNumber : singleNumbers) {
            value *= singleNumber;
        }
        return value;
    }


    private static int getAnswer(Integer x, Integer y) {
        return (x < y) ? 2 : ((x == y) ? 0 : 1);
    }




}