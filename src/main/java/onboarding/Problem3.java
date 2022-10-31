package onboarding;

import java.util.Arrays;
import java.util.HashSet;

public class Problem3 {

    static int answer;
    static HashSet<Integer> set369 = new HashSet<>(Arrays.asList(3,6,9));

    public static int solution(int number) {

        answer = 0;

        Number input = new Number(number);

        for (int i = 1; i <= number; i++) {
            check369(i);
        }
        return answer;

    }

    // 각 자리수에 3,6,9가 있는지 체크하는 메소드
    public static void check369 (int number) {
        int n;
        while (number > 0) {
            n = number % 10;
            if (set369.contains(n)) {
                answer++;
            }
            number /= 10;
        }
    }
}

class Number {
    private int number;

    public Number(int input) {
        validateSize(input);
        this.number = input;
    }

    private void validateSize(int input) {
        if(input < 1) {
            throw new IllegalArgumentException("1이상 값을 입력하세요.");
        }
        if (input > 10000) {
            throw new IllegalArgumentException("10000이하 값을 입력하세요");
        }
    }


}

