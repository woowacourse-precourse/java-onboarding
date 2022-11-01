package onboarding;

public class Problem3 {
    public static final int THREE = 3;
    public static final int SIX = 6;
    public static final int NINE = 9;

    public static int solution(int number) {
        int answer = 0;
        for (int i = 3; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }

    public static int getClapCount(int number) {
        int clap = 0;
        do {
            switch (number % 10) {
                case THREE:
                case SIX:
                case NINE:
                    clap++;
            }
            number /= 10;
        } while (number != 0);
        return clap;
    }
}
