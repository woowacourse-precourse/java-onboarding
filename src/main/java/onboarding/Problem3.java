package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(solution(13));
    }
    static String getRangedString(int n) {
        String StringNumber = IntStream.rangeClosed(1, n).mapToObj(String::valueOf).reduce("", String::concat);
        return StringNumber;
    }

    static int getCountOfNumbers(String s) {
        return 0;
    }

    public static int solution(int number) {
        int answer = 0;
        String numberString = getRangedString(number);
        answer = getCountOfNumbers(numberString);
        return answer;
    }
}
