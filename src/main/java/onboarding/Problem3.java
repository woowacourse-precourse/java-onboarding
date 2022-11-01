package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = computeTotalClap(number);
        return answer;
    }

    private static int countClap(int i) {
        int count = 0;

        while (i > 0) {
            int mod = i % 10;
            if (mod == 3 || mod == 6 || mod == 9) {
                count++;
            }
            i = i / 10;
        }

        return count;
    }

    public static int computeTotalClap(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += countClap(i);
        }

        return sum;
    }
}
