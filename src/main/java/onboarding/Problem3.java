package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem3 {
    public static List<Integer> splitNumber(int number){
        return Stream.of(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int count369(List<Integer> number){
        return (int) number.stream()
                .filter(x->x==3||x==6||x==9)
                .count();
    }

    public static int countClap(int number){
        return IntStream.range(1,number+1)
                .map(x->count369(splitNumber(x)))
                .sum();
    }

    public static void checkNumber(int number){
        if(number>10000||number<1)
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
    }

    public static int solution(int number) {
        checkNumber(number);
        return countClap(number);
    }
}
