package onboarding;

public class Problem3 {

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 입력으로 주어진 정수입니다.
     * @return 정수가 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(int number) {
        boolean valid = isInRange(number);
        return valid;
    }

    /*
     * 입력의 범위가 유효한지 검사합니다.
     *
     * @param 입력으로 주어진 정수입니다.
     * @return 정수의 값이 1 ~ 10000 이내라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isInRange(int number) {
        boolean valid =
                number > 0 &&
                number <= 10000;
        return valid;
    }

    /*
     * 범위 내의 숫자들에 3, 6, 9가 몇 개가 있는지 셉니다.
     *
     * @param 범위를 표현하는 정수입니다.
     * @return 인자값 까지 숫자들의 3, 6, 9 개수입니다.
     * */
    private static int count369InRange(int range) {
        int count = 0;
        for (int i = 1; i <= range; i++) {
            count += count369InNumber(i);
        }
        return count;
    }

    /*
     * 숫자 하나 안에서 3, 6, 9가 몇 개가 있는지 셉니다.
     *
     * @param 개수를 셀 숫자힙니다.
     * @return 숫자의 3, 6, 9 개수입니다.
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

    /*
     * 숫자가 3, 6, 9인지 알려줍니다.
     *
     * @param 한 자릿수 정수입니다.
     * @return 3, 6, 9 라면 1, 아니면 0을 반환합니다.
     * */
    private static int is369 (int digit) {
        if (digit == 3 || digit == 6 || digit == 9) {
            return 1;
        }
        return 0;
    }

    /*
     * Problem3의 솔루션 코드입니다.
     *
     * @param 3, 6, 9의 개수를 셀 숫자의 범위 입니다.
     * @return 숫자 범위 내의 3, 6, 9 개수입니다.
     * */
    public static int solution(int number) {
        if (isValidInput(number) == false) {
            return -1;
        }

        int answer = count369InRange(number);
        return answer;
    }
}
