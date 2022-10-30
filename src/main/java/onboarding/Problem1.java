package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);

        return answer;
    }
    public static  int getMaxValue(List<Integer> list){
        List<Integer> maxValue = new ArrayList<>();
        for (Integer el: list){
        maxValue.add(Math.max(getSumValue(el), getMultiplyValue(el)));

        }
        return (Math.max(maxValue.get(0), maxValue.get(1)));
    }

    public static int getSumValue(Integer number){
        return Stream.of(number.toString().split("")).mapToInt(Integer::parseInt).sum();
    }
    public static int getMultiplyValue(Integer number) {
        return Stream.of(number.toString().split("")).mapToInt(Integer::parseInt).reduce(1, (a,b) -> a * b);
    }
}