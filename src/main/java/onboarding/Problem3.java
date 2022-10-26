package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            answer += getNumOfClapOf(i);
        }
        return answer;
    }

    private static int getNumOfClapOf(int number) {
        int result = 0;
        while (number != 0) {
            if (is369(number%10))
                result++;
            number /= 10;
        }
        return result;
    }

    private static boolean is369(int number) {
        if (number == 0)
            return false;
        return number % 3 == 0;
    }
}
