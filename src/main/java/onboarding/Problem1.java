package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

class Problem1 {



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getAnswer(getMaxValue(pobi), getMaxValue(crong));
        return answer;
    }

    private static Integer getMaxValue(List<Integer> pages) {
        List<Integer> calResultList = new ArrayList<>();

        for (Integer page : pages) {
            List<Integer> singleNumbers = getSingleNumbers(page);
            doCalculate(singleNumbers, calResultList);
        }
        return max(calResultList);
    }

    private static List<Integer> getSingleNumbers(Integer integer) {
        List<Integer> valueList = new ArrayList<>();
        int loof = integer.toString().length();
        for (int i = 0; i < loof; i++) {
            valueList.add(integer % 10);
            integer /= 10;
        }
        return valueList;
    }

    private static void doCalculate(List<Integer> values, List<Integer> calResults) {
        int all_Plus = 0;
        int all_multiply = 1;
        for (Integer value : values) {
            all_Plus += value;
            all_multiply *= value;
        }
        calResults.add(all_Plus);
        calResults.add(all_multiply);
    }


    private static int getAnswer(Integer x, Integer y) {
        return (x < y) ? 2 : ((x == y) ? 0 : 1);
    }




}