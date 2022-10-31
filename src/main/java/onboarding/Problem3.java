package onboarding;

public class Problem3 {

    /**
     * 범위 내의 숫자들에 3, 6, 9가 몇 개가 있는지 셉니다.
     *
     * @param range 범위를 표현하는 정수입니다.
     * @return 해당 범위에 포함된 숫자들에 있는 3, 6, 9 개수입니다.
     * */
    private static int count369InRange(int range) {
        int count = 0;
        for (int i = 1; i <= range; i++) {
            count += count369InNumber(i);
        }
        return count;
    }

    /**
     * 숫자 하나 안에서 3, 6, 9가 몇 개가 있는지 셉니다.
     *
     * @param number 개수를 셀 숫자입니다.
     * @return 숫자안에 있는 3, 6, 9 개수입니다.
     * */
    private static int count369InNumber(int number) {
        int count = 0;

        while (number > 0) {
            int digit = number % 10;
            count += is369(digit);
            number /= 10;
        }
        return count;
    }

    /**
     * 숫자가 3, 6, 9인지 알려줍니다.
     *
     * @param digit 정수입니다.
     * @return 3, 6, 9 중 하나라면 1, 아니면 0을 반환합니다.
     * */
    private static int is369 (int digit) {
        if (digit == 3 || digit == 6 || digit == 9) {
            return 1;
        }
        return 0;
    }

    /**
     * Problem3의 솔루션 코드입니다.
     *
     * @param number 3, 6, 9의 개수를 셀 숫자의 범위 입니다.
     * @return 숫자 범위 내의 3, 6, 9 개수입니다.
     * */
    public static int solution(int number) {
        int answer = count369InRange(number);
        return answer;
    }
}
