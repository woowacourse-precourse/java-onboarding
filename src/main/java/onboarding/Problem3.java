package onboarding;

public class Problem3 {
    public static int[] clapsMemoization = new int[10001];
    public static int currentNumberOfFilledClapsMemo = 0;

    public static int solution(int number) {
        return findNumberOfClaps(number);
    }

    private static int findNumberOfClaps(int number) {
        if (number > currentNumberOfFilledClapsMemo) {
            fillMemoUpTo(number);
        }
        return clapsMemoization[number];
    }
}
