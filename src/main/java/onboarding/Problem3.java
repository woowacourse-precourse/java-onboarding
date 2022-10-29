package onboarding;

public class Problem3 {

    /**
     * 해당 숫자가 박수를 쳐야 하는지 확인한다.
     * @param input
     * @return
     */
    private static int shouldClap(int input) {
        int count = 0;
        while(input >= 10) {
            if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9) {
                count++;
            }
            input /= 10;
        }
        if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9) {
            count++;
        }
        return count;
    }

    /**
     * 1부터 number까지 총 박수를 쳐야 하는 횟수를 구한다.
     * @param number
     * @return
     */
    private static int getTotalClaps(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (shouldClap(i)) {
                count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
