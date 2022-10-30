package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            answer += countClapOfNum(i);
        }
        return answer;
    }

    // 해당 수에서의 박수 횟수 구하기
    public static int countClapOfNum(int number) {
        int count = 0;
        while (number != 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9)
                count++;
            number /= 10;
        }
        return count;
    }
}
