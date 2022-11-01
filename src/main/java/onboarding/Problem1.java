package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)){
            return -1;
        }


        int i = getMaxPobiNum(pobi);
        int j = getMaxCroniNum(crong);
        if (i > j) {
            return 1;
        } else if (i < j) {
            return 2;
        } else if(i == j){
            return 0;
        }else {
            return -1;
        }

    }

    public static int getMaxPobiNum(List<Integer> list1) {

        int leftPobi = list1.get(0); //97
        int rightPobi = list1.get(1); // 98

        List<Integer> maxList = getIntegers(leftPobi, rightPobi);


        return maxList.get(maxList.size() - 1);
    }

    public static int getMaxCroniNum(List<Integer> list1) {

        int leftCrong = list1.get(0); //197
        int rightCrong = list1.get(1); // 198

        List<Integer> maxList = getIntegers(leftCrong, rightCrong);


        return maxList.get(maxList.size() - 1);
    }

    private static List<Integer> getIntegers(int leftCrong, int rightCrong) {
        int leftSumCr = Stream.of(String.valueOf(leftCrong).split("")).mapToInt(Integer::parseInt).sum(); // 17
        int leftMultCr = Stream.of(String.valueOf(leftCrong).split("")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b); // 63


        int rightSumCr = Stream.of(String.valueOf(rightCrong).split("")).mapToInt(Integer::parseInt).sum(); //18
        int rightMultCr = Stream.of(String.valueOf(rightCrong).split("")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b); // 72


        List<Integer> maxList = new ArrayList<>(Arrays.asList(leftSumCr, leftMultCr, rightSumCr, rightMultCr));
        Collections.sort(maxList);
        return maxList;
    }


}