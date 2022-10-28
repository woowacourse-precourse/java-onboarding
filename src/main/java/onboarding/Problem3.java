package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
            String currentNum = String.valueOf(i);

            for (int j = 0; j < currentNum.length(); j++) {
                char digit = currentNum.charAt(j);

                if (digit == '3' || digit == '6' || digit == '9') {
                    clap++;
                }
            }
        }

        return clap;
    }
}
