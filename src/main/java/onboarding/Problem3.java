package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    public static int[] eachDigit(int num){
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }
}
