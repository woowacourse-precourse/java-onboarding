package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++)
            answer += countClaps(i);
        return answer;
    }
    public static int countClaps(int number) {
        int tmp, cnt = 0;
        while (number > 0) {
            tmp = number % 10;
            if (tmp == 3 || tmp == 6 || tmp == 9)
                cnt++;
            number /= 10;
        }
        return cnt;
    }

}
