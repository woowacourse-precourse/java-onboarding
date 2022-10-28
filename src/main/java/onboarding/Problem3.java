package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <369 게임>
 * 기능 : 1. 숫자를 제시하면 숫자를 말하는 대신 3,6,9의 개수 만큼 손뼉를 친다.
 *       2. number가 주어지면 1부터 number까지 손뼉을 횟수를 return 한다.
 * 제한사항 : number는 1이상 10000이하 자연수
 */
public class Problem3 {
    private static final Integer EXCEPTION = -1;
    public static int solution(int number) {
        return restrictions(number)
                ? EXCEPTION
                : clapCount(number);
    }

    private static boolean restrictions(int number) {
        return number < 1 || number > 10000;
    }

    private static int[] find369(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(num -> String.valueOf(num).matches("^[0-9]*[369][0-9]*$"))
                .toArray();
    }

    private static int clapCount(int number) {
        return Arrays.toString(find369(number))
                .replaceAll("[^369]","")
                .length();
    }
}
