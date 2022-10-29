package onboarding;

public class Problem3 {
    public static int[] notation;
    public static int solution(int number) {
        int answer = 0;

        notation = new int[10000];
        notation[0] = 0;
        notation[1] = 0;
        notation[2] = 0;

        answer = increasingCrapCount(number);

        return answer;
    }
}
