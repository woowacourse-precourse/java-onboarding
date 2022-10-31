package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getClapNumber(i);
        }

        return answer;
    }

    private static int getClapNumber(Integer targetNum) {
        int ret = 0;

        int leftNum = targetNum;
        int curPos = 10;
        while (leftNum != 0) {
            int eachNumber = leftNum % curPos;
            if (eachNumber == 3 || eachNumber == 6 || eachNumber == 9) {
                ret++;
            }
            leftNum /= curPos;
        }
        return ret;
    }
}
