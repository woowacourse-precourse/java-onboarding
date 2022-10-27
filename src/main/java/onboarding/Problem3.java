package onboarding;

public class Problem3 {
    static final int THREE = 3;
    static final int SIX = 6;
    static final int NINE = 9;

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += find369(i);
        }

        return answer;
    }

    public static  int find369(int number) {
        int count = 0;

        while (number != 0) {
            int remainder = number % 10;
            if (remainder == THREE || remainder == SIX || remainder == NINE) {
                count++;
            }
            number /= 10;
        }

        return count;
    }
}
