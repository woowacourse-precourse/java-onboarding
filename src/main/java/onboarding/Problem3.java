package onboarding;

public class Problem3 {

    public static int getClaps(int number) {
        // number에 대한 필요한 박수의 횟수를 반환하는 함수.
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9)
                result++;
            number /= 10;
        }
        return result;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int increment = 0; increment <= number; increment++) {
            answer += getClaps(increment);
        }

        return answer;
    }
}
