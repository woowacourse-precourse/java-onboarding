package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += NumberUtils.count369(i);
        }
        return answer;
    }

    static class NumberUtils {

        private NumberUtils() {
        }

        private static int count369(int number) {
            int mod = 1;
            int count = 0;
            while ((number / mod) != 0) {
                int temp = (number / mod) % 10;
                if (is369(temp)) {
                    count++;
                }
                mod *= 10;
            }
            return count;
        }

        private static boolean is369(int number) {
            return (number == 3 || number == 6 || number == 9);
        }
    }
}
