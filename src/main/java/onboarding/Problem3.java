package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count;

        if (throwBoundaryException(number)) {
            return -1;
        }

        for (count = 1; count <= number; count++) {
            answer += countClapNumber(count);
        }

        return answer;
    }

    public static boolean throwBoundaryException(int number) {
        if (number < 1 || number > 10000) {
            return true;
        }

        return false;
    }

    public static int countClapNumber(int number) {
        int countClap = 0;
        int compare;

        while (number > 0) {
            compare = number % 10;
            if (compare == 3 || compare == 6 || compare == 9) {
                countClap += 1;
            }
            number /= 10;
        }

        return countClap;
    }
}