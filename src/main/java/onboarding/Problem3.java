package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int[] converter(int num){
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean check369(int num){
        return num == 3 || num == 6 || num == 9;
    }
}
