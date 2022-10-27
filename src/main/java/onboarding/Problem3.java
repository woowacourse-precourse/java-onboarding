package onboarding;

public class Problem3 {

    private static boolean isValidInput(int number) {
        return false;
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
