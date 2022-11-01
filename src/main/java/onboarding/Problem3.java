package onboarding;

public class Problem3 {
    static int[] checkNumber = {3, 6, 9};
    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            int pow = 0;
            while (i >= Math.pow(10, pow)) {
                int n = i % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
                if (n == 3 || n == 6 || n == 9) {
                    result += 1;
                }
                pow += 1;
            }
        }

        return result;
    }

    private static boolean needCrap(int number) {
        for (int check : checkNumber) {
            if (check == number) {
                return true;
            }
        }
        return false;
    }
}
