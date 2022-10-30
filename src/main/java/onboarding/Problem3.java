package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = countClap(number);
        return answer;
    }

    private static int countClap(Integer number) {
        int cnt = 0;
        for(int i = 1; i < number + 1; i++) {
            int[] arrNum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            cnt += (int) Arrays.stream(arrNum).filter(num -> num == 3 || num == 6 || num == 9).count();
        }
        return cnt;
    }
}
