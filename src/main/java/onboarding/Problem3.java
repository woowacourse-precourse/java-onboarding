package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            int curr = i;

            while (curr > 0) {
                int mod = curr % 10;
                if (mod == 3 || mod == 6 || mod == 9) {
                    answer += 1;
                }
                curr /= 10;
            }
        }
        return answer;
    }
}

