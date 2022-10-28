package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int getClapCount(int number) {
        int count = 0;
        while (number != 0) {
            int digitNumber = number % 10;
            if (isThree(digitNumber) || isSix(digitNumber) || isNine(digitNumber)) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    private static boolean isThree(int digitNumber) {
        return digitNumber == 3;
    }

    private static boolean isSix(int digitNumber) {
        return digitNumber == 6;
    }

    private static boolean isNine(int digitNumber) {
        return digitNumber == 9;
    }
}
