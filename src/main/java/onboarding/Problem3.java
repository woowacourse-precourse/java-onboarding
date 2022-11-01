package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int temp = i;

            while (temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9)
                    clapCount++;

                temp /= 10;
            }
        }
        answer = clapCount;

        return answer;
    }
}
