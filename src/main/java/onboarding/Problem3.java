package onboarding;

public class Problem3 {
    static int[] checkNumber = {3, 6, 9};
    public static int solution(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            int pow = 0;
            while (i >= Math.pow(10, pow)) {
                int n = digitNumber(i, pow);
                if (needCrap(n)) {
                    result += 1;
                }
                pow += 1;
            }
        }

        return result;
    }

    private static int digitNumber(int number, int pow) {
        return number % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
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
