package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<Integer> calResultListByPobi = getResult(pobi);
        List<Integer> calResultListByCrong = getResult(crong);
        int answer = max(calResultListByPobi).compareTo(max(calResultListByCrong));
        return answer;
    }

    private static List<Integer> getResult(List<Integer> participant) {
        List<Integer> calResultList = new ArrayList<>();

        for (Integer integer : participant) {
            List<Integer> singleNumbers = getSingleNumbers(integer);
            doCalculate(singleNumbers, calResultList);
        }
        return calResultList;
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

    private static void doCalculate(List<Integer> valueList, List<Integer> calResultList) {
        int all_Plus = 0;
        int all_multiply = 1;
        for (Integer values : valueList) {
            all_Plus += values;
            all_multiply *= values;
        }
        calResultList.add(all_Plus);
        calResultList.add(all_multiply);
    }

}