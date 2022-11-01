package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getTotalClapNumber(number);
    }

    private static int getTotalClapNumber(int number) {
        Integer result = 0;
        for (int i = 1; i <= number; i++) {
            result += getSingleClapNum(i);
        }
        return result;
    }

    private static Integer getSingleClapNum(int singleNum) {
        Integer result = 0;
        while (singleNum != 0) {
            Integer remain = singleNum % 10;
            if (remain == 3 || remain == 6 || remain == 9) {
                result += 1;
            }
            singleNum /= 10;
        }
        return result;
    }
}
