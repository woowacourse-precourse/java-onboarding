package onboarding;

import java.util.stream.Stream;

public class Problem3 {

    /**
     * 바운더리(1미만, 10000 초과)를 체크하는 메서드 입니다.
     * @param number
     */
    public static void overBoundaryException(int number) {
        if(number > 10000 || number < 1) {
            throw new RuntimeException("인풋 바운더리를 초과했습니다.(number: " + number);
        }
    }

    /**
     * 주어진 숫자에 있는 3,6,9의 갯수를 세는 메서드 입니다.
     * @param number
     * @return
     */
    public static int count369(int number) {
        String[] num = String.valueOf(number).split("");

        return (int) Stream.of(num)
                .filter(x -> x.equals("3") || x.equals("6") || x.equals("9")).count();
    }

    public static int solution(int number) {
        overBoundaryException(number);

        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += count369(i);
        }

        return result;
    }
}
