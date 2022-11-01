package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;

        for (int i = 1; i <= number; i++) {
            char[] numbers = Integer.toString(i).toCharArray();

            for (char num : numbers) {
                if (num == '3' || num == '6' || num == '9') clap++;
            }
        }

        return clap;
    }
}
