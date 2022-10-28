package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        if (number < 1 || number > 10000)
            return EXCEPTION;
        return count369(number);
    }

    private static int count369(int number) {
        int[] numbers369 = IntStream.rangeClosed(1, number)
                .filter(num -> String.valueOf(num).matches("^[0-9]*[369][0-9]*$"))
                .toArray();

        Pattern pattern = Pattern.compile("[369]");
        int clapCount = 0;
        for (int i : numbers369) {
            Matcher matcher = pattern.matcher(String.valueOf(i));
            while (matcher.find())
                clapCount += 1;
        }
        return clapCount;
    }
}
