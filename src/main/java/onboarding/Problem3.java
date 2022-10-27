package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (isExceptionInput(number)) return -1;

        for (int i = 1; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }

    private static boolean isExceptionInput(int number) {
        return number < 1 || number > 10000;
    }

    private static int getClapCount(int num) {
        int clapCount = 0;

        while (num > 0) {
            int oneNum = num % 10;
            num /= 10;
            if (oneNum != 0 && oneNum % 3 == 0) clapCount++;
        }
        return clapCount;
    }

}
