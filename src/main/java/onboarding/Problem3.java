package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }

    public static int count(int targetNumber) {
        int result = 0;

        while (targetNumber > 0) {
            int nowNumber = targetNumber % 10;
            if(nowNumber == 3 || nowNumber == 6 || nowNumber == 9) {
                result++;
            }
            targetNumber /= 10;
        }

        return result;
    }
}
