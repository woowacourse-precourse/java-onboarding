package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getClapCount(number);
    }

    public static int getClapCount(int number) {
        int claps = 0;

        for (int i=1; i<=number; i++) {
            String curNumber = String.valueOf(i);
            for (char digit : curNumber.toCharArray()) {
                if (digit == '3' || digit == '6' || digit == '9') claps++;
            }
        }

        return claps;
    }
}
