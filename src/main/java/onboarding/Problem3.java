package onboarding;

public class Problem3 {
    static int[] clapCountArr = new int[10001];

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean isClapped(int target) {
        return target == 3 || target == 6 || target == 9;
    }

    private static boolean isCached(int target) {
        return clapCountArr[target] > 0;
    }
}
