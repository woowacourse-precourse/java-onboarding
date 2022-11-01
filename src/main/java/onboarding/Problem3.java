package onboarding;

public class Problem3 {
    private static int count;

    public static int solution(int number) {
        count = 0;
        for (int i = 1; i <= number; i++) {
            checkNumber(i);
        }
        return count;
    }

    private static void checkNumber(int num) {
        StringBuilder number = new StringBuilder(Integer.toString(num));

        for (int i = 0; i < number.length(); i++) {
            check369(number.charAt(i));
        }
    }

    private static void check369(char num) {
        if (num == '3' || num == '6' || num == '9')
            count++;
    }
}
