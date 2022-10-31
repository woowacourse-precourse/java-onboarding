package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static List<Integer> getDigitList(int num){
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void count(int count,List<Integer> digitList){
        for (Integer digit : digitList) {
            checkCondition(count,digit);
        }
    }

    public static void checkCondition(int count,int digit){
        if (digit % 3 ==0){
            count++;
        }
    }
}
