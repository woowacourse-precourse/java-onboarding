package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1 ; num <= number; num++){
            answer += count(getDigitList(num));
        }
        return answer;
    }

    public static List<Integer> getDigitList(int num){
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int count(List<Integer> digitList){
        int count = 0;
        for (Integer digit : digitList) {
            count += checkCondition(digit);
        }
        return count;
    }

    public static int checkCondition(int digit){
        if (digit != 0 && digit % 3 ==0){
            return 1;
        }
        return 0;
    }
}
