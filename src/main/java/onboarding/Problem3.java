package onboarding;

public class Problem3 {
    public static int solution(int number) {
        check1(number);
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;
            while (num != 0) {
                if ((num % 10 == 3) || (num % 10 == 6) || (num % 10 == 9)) {
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }
    public static void check1(int number) throws IllegalArgumentException{
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("0이거나 숫자 범위를 벗어났습니다.");
        }

    }
}
