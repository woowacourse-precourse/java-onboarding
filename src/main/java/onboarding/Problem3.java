package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (isValidInput(number)) {
            answer = sumTotalClap(number);
        }
        return answer;
    }

    private static boolean isValidInput(int number) {
        return number >= 1 && number <= 10000;
    }

    private static int sumTotalClap(int number) {
        int totalCount = 0;
        for (int i = 1; i <= number; i++) {
            totalCount += countClap(i);
        }
        return totalCount;
    }

    private static int countClap(int i) {
        int count = 0;
        while (i != 0) {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                count += 1;
            }
            i /= 10;
        }
        return count;
    }
}
