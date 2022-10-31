package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            answer += getClapCounts(i);
        }
        return answer;
    }

    private static int getClapCounts(int number) {
        int cnt = 0;
        int temp;
        while (number != 0) {
            temp = number % 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                cnt += 1;
            }
            number /= 10;
        }
        return cnt;
    }
}
