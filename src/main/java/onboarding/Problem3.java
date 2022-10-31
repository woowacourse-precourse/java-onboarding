package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    public static int count369(int num) {
        int count = 0;

        while (num > 0) {
            int mod = num % 10;
            if (mod == 3 || mod == 6 || mod == 9) count++;
            num /= 10;
        }

        return count;
    }
}
