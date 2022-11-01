package onboarding;

/**
 * [기능 구현]
 * 1. 주어진 숫자의 각 자릿수의 수 중 3,6,9의 개수를 세는 메소드
 */
public class Problem3 {

    // 각 자릿수가 3,6,9 를 포함하는지 확인 후 개수를 증가시켜주는 메소드
    private static int doClap(int num) {
        int cnt = 0;

        while (num > 0) {
            int rem = num % 10; // 각 자릿수를 나머지 연산을 통해 뽑아줌
            if (rem == 3 || rem == 6 || rem == 9) cnt++; // 3,6,9 중 해당하는 경우 +1
            num /= 10;
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += doClap(i);
        }

        return answer;
    }
}
