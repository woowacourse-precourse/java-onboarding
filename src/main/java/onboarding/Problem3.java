package onboarding;

public class Problem3 {

    /**
     * 해당 숫자가 박수를 쳐야 하는지 확인한다.
     * @param input
     * @return
     */
    private static boolean shouldClap(int input) {
        while(input >= 10) {
            if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9) {
                return true;
            }
            input /= 10;
        }
        if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9) {
            return true;
        }
        return false;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
