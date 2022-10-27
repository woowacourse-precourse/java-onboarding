package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        IntStream allNums = IntStream.range(1, number + 1);
        return allNums.map(num -> countClap(num)).sum();
    }

    static int countClap(Integer num){
        String[] numTokens = num.toString().split("");
        IntStream tokenStream = Arrays.stream(numTokens).mapToInt(Integer :: parseInt);
        IntStream clapTokens = tokenStream.filter(t -> ((t == 3) || (t == 6) || (t == 9)));

        return (int) clapTokens.count();
    }
}
