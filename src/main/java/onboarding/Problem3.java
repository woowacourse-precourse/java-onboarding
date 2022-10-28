package onboarding;

public class Problem3 {
    // number에서 3, 6, 9의 개수를 세주는 메서드
    public static int count(int number) {
        int cnt = 0;
        while (number != 0) {
            int n = number % 10;
            if (n == 3 || n == 6 || n == 9) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        // 1부터 number까지 3,6,9 개수 계산하기
        int cnt = 0;
        for (int i = 1; i <= number; i++) {
            cnt += count(i);
        }
        return cnt;
    }
}
