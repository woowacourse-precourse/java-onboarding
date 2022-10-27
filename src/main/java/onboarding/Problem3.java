package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static int countClap(Integer num){
        String[] numTokens = num.toString().split("");
        Stream<String> tokenStream = Arrays.stream(numTokens);
        Stream<String> clapTokens = tokenStream.filter(t -> ((t == "3") || (t == "6") || (t == "9")));

        return (int) clapTokens.count();
    }
}
