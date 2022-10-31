package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    /**
     * 매개변수로 주어진 n에 들어가는 3, 6, 9의 개수를 구해 리턴
     */
    public static int count369(int n) {
        int cnt = 0;

        while (n > 0) {
            int tmp = n % 10;

            if (tmp == 3 || tmp == 6 || tmp == 9)
                cnt++;

            n /= 10;
        }

        return cnt;
    }
}
