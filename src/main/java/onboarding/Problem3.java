package onboarding;

public class Problem3 {

    public static int checkNumber(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int num = i;
            while (num > 0) {
                int mod = num % 10;
                if (mod == 3 || mod == 6 || mod == 9) answer++;
                num /= 10;
            }
        }
        return answer;
    }

    public static int solution(int number) {
        return checkNumber(number);
    }
}
