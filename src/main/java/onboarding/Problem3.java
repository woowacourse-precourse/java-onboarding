package onboarding;

public class Problem3 {

    /**
     * 숫자를 입력 받았을 때 각 자리 수에서 3, 6, 9가 몇 번 나오는 지 계산하여 풀었음.
     */
    public static int solution(int number) {
        int answer = 0;

        answer += calculateOneDigits(number);
        answer += calculateOtherDigits(number);

        return answer;
    }

    /**
     * calculateOneDigits 메소드는 일의 자리 수에서 3, 6, 9가 몇 번 나왔는 지 계산하는 메소드
     */
    private static int calculateOneDigits(int number) {
        int oneDigitsCounts = number / 10 * 3 + number % 10 / 3;
        return oneDigitsCounts;
    }

    /**
     * calculateOtherDigits 메소드는 일의 자리 수를 제외한 자리 수들에서 3, 6, 9가 몇 번 나왔는 지 계산하는 메소드
     */
    private static int calculateOtherDigits(int number) {
        /** 
         * rotateCounts 변수는 한 자리 수에서 수가 바뀐 횟수를 뜻함
         * divisor 변수는 현재 계산하고 있는 자리 수를 뜻함
         */
        int rotateCounts;
        int otherDigitsCounts = 0;
        int divisor = 10;

        while (divisor <= number) {
            rotateCounts = number / divisor;
            otherDigitsCounts += rotateCounts / 10 * 3 * divisor;
            if (rotateCounts % 10 == 0) {
                divisor *= 10;
                continue;
            }

            otherDigitsCounts += (rotateCounts - 1) % 10 / 3 * divisor;
            if (rotateCounts % 10 % 3 == 0) {
                otherDigitsCounts += number % divisor + 1;
            }
            divisor *= 10;
        }
        return otherDigitsCounts;
    }
}
