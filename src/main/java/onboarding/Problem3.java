package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Utility{
    final int startNumber=1;
    int[] makeArray(int endNumber){
        return IntStream.range(startNumber,endNumber).toArray();
    }
    int[] divideEachDigit(int number) {
        int[] digitNum;
        digitNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digitNum;
    }
}
class Game{
    final int[] clapCondition = {3,6,9};
    boolean isClap(int digit){
        return IntStream.of(clapCondition).anyMatch(condition->condition==digit);
    }
}

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
