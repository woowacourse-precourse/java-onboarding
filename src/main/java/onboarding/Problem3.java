package onboarding;

public class Problem3 {
    public static int[] tqqq;
    public static int solution(int number) {
        int answer = 0;

        tqqq = new int[10000];
        tqqq[0] = 0;
        tqqq[1] = 0;
        tqqq[2] = 0;

        answer = increasingCrapCount(number);

        return answer;
    }

    private static int increasingCrapCount(int number) {
        String idxToStr = "";

        for (int idx = 3; idx < number; idx++) {
            
        }
        return tqqq[number];
    }
}
