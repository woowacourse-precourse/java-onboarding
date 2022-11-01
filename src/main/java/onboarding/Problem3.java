package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 0; i <= number; i++){
            answer += count369InNumber(i);
        }
        return answer;
    }

    public static int count369InNumber(int number){
        List<String> numberList = Stream.of(Integer.toString(number).split("")).collect(Collectors.toList());
        int count = 0;
        count += Collections.frequency(numberList, "3");
        count += Collections.frequency(numberList, "6");
        count += Collections.frequency(numberList, "9");
        return count;
    }
}