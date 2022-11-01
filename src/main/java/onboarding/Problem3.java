package onboarding;

public class Problem3 {
    static final int THREE = 3;
    static final int SIX = 6;
    static final int NINE = 9;
    static final int TEN = 10;

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getCountOfNumber(THREE, i);
            answer += getCountOfNumber(SIX, i);
            answer += getCountOfNumber(NINE, i);
        }
        return answer;
    }

    public static int getCountOfNumber(int target, int number) {
        int count = 0;
        while (true) {
            int rest = number % TEN;
            number /= TEN;
            if (rest == target) {
                count++;
            }
            if (number == 0) {
                break;
            }
        }
        return count;
    }
}
