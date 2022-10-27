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

    private static int count369InRange(int number) {
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
