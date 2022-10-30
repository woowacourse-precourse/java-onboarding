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

    private static void fillMemoUpTo(int number) {
        for (int i = currentNumberOfFilledClapsMemo + 1; i <= number; i++) {
            fillMemo(i);
            currentNumberOfFilledClapsMemo++;
        }
    }

    private static void fillMemo(int number) {
        int NumberOf369 = findNumberOf369(number);
        clapsMemoization[number] = clapsMemoization[number - 1] + NumberOf369;
    }

    private static int findNumberOf369(int number) {
        int count = 0;

        while (number != 0) {
            if (is369(number % 10)) count++;
            number /= 10;
        }
        return count;
    }

    private static boolean is369(int number) {
        return (number == 3) || (number == 6) || (number == 9);
    }
}
