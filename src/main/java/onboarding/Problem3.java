package onboarding;

import java.util.List;

public class Problem3 {
    /*
    기능목록
    1. 수의 각 자릿수를 검사해서 손뼉의 횟수를 세는 기능
     */
    private static List<Integer> CLAP_NUMBERS = List.of(3, 6, 9);
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    // 수의 각 자릿수를 검사해서 손뼉의 횟수를 리턴한다.
    private static int countClap(int number) {
        int result = 0;
        while (number > 0) {
            int n = number % 10;
            if (CLAP_NUMBERS.contains(n)) {
                result++;
            }
            number /= 10;
        }
        return result;
    }

}
