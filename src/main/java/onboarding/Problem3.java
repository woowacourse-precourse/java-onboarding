package onboarding;

import java.util.List;

public class Problem3 {
    public static final List<String> include369array = List.of("3", "6", "9");

    public static void main(String[] args) {
        System.out.println(solution(33));
    }

    public static int solution(int number) {
        return countClap(number);
    }

    // 손뼉을 친 횟수
    private static int countClap(int number) {
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += separateEachDigit(i);
        }

        return cnt;
    }

    // 숫자의 각 자리 분리
    private static int separateEachDigit(int number) {
        int cnt = 0;
        while (number != 0) {
            if (isInclude3or6or9(number % 10)) {
                cnt++;
            }
            number /= 10;
        }

        return cnt;
    }

    // 3, 6, 9가 포함된 숫자인가
    private static boolean isInclude3or6or9(int number) {
        return include369array.stream()
                .anyMatch(n -> String.valueOf(number).contains(n));
    }
}
