package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int temp = i;
            while (temp > 0) {
                int temp2 = temp % 10;
                if (temp2 != 0 && temp2 % 3 == 0) {
                    answer++;
                }
                temp /= 10;
            }
        }

        return answer;
    }
}
