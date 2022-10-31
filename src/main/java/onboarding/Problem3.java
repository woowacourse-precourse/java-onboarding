package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int digit;
        for(int i = 1; i <= number; i++) {
            if (i < 10) {
                if (i == 9 || i == 6 || i == 3)
                    answer++;
            }
            else if (i >= 10 && i < 100) {
                if (i / 10 == 9 || i / 10 == 6 || i / 10 == 3)
                    answer++;
                digit = i % 10;
                if (digit == 9 || digit == 6 || digit == 3)
                    answer++;
            }
            else if (i >= 100 && i < 1000) {
                if (i / 100 == 9 || i / 100 == 6 || i / 100 == 3)
                    answer++;
                digit = i % 100;
                if (digit / 10 == 9 || digit / 10 == 6 || digit / 10 == 3)
                    answer++;
                digit = digit % 10;
                if (digit % 10 == 9 || digit % 10 == 6 || digit % 10 == 3)
                    answer++;
            }
            else {
                if (i / 1000 == 9 || i / 1000 == 6 || i / 1000 == 3)
                    answer++;
                digit = i % 1000;
                if (digit / 100 == 9 || digit / 100 == 6 || digit / 100 == 3)
                    answer++;
                digit = digit % 100;
                if (digit / 10 == 9 || digit / 10 == 6 || digit / 10 == 3)
                    answer++;
                digit = i % 10;
                if (digit == 9 || digit == 6 || digit == 3)
                    answer++;
            }
        }
        return answer;
    }
}
