package onboarding;

public class Problem3 {

    /**
     * 바운더리(1미만, 10000 초과)를 체크하는 메서드 입니다.
     * @param number
     */
    public static void overBoundaryException(int number) {
        if(number > 10000 || number < 1) {
            throw new RuntimeException("인풋 바운더리를 초과했습니다.(number: " + number);
        }
    }
    public static int solution(int number) {
        overBoundaryException(number);
    }
}
