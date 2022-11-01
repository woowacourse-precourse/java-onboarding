package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += numOfClaps(i);
        }

        return answer;
    }

    // 현재 숫자에 대해 손뼉을 몇 번 쳐야하는지 반환
    public static int numOfClaps(int num) {
        int result = 0;
        while (num > 1) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9)
                result++;

            num /= 10;
        }
        return result;
    }
}
