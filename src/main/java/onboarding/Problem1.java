package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getSumValue(Integer number){
        return Stream.of(number.toString().split("")).mapToInt(Integer::parseInt).sum();
    }

}