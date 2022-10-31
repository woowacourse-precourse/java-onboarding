package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Utility{
    int[] divideEachDigit(int number) {
        int[] digitNum;
        digitNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digitNum;
    }
}
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
