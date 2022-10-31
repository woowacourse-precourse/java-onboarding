package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;

        for (int i = 3; i <= number; i++) {
            final String stringOfNumber = String.valueOf(i);
            clap += (stringOfNumber.length() - stringOfNumber.replaceAll("[369]", "").length());
        }

        return clap;
    }
}
