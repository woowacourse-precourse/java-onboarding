package onboarding;

public class Problem3 {
    public static int getThreeCnt(int number) {
        int cnt = 0;

        while (number != 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9)
                cnt += 1;
            number /= 10;
        }

        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++)
            answer += Problem3.getThreeCnt(i);

        return answer;
    }
}
