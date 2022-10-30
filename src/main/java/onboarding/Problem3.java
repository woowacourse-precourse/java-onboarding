package onboarding;

public class Problem3 {
    public static int solution(int number) {
        final int THRESHOLD = 2;

        int clap = 0;

        while (number > THRESHOLD) {
            String digits = Integer.toString(number);

            for (int i=0; i<digits.length(); i++) {
                char digitChar = digits.charAt(i);
                int digit = Integer.parseInt(String.valueOf(digitChar));
            }
        }

        int answer = 0;
        return answer;
    }
}
