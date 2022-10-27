package onboarding;

public class Problem3 {

    static int[] clapCountArr = new int[10001];

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int calculateTargetClapCount(int target) {
        int clapCount = 0;

        while (target != 0) {
            int targetDigit = target % 10;
            target /= 10;

            if (isCached(targetDigit)) {
                clapCount += clapCountArr[targetDigit];
                continue;
            }
            clapCount += calculateTargetDigitClapCount(targetDigit);
        }
        return clapCount;
    }

    private static int calculateTargetDigitClapCount(int target) {
        if (isClapped(target)) {
            return ++clapCountArr[target];
        }
        return 0;
    }

    private static boolean isClapped(int target) {
        return target == 3 || target == 6 || target == 9;
    }

    private static boolean isCached(int target) {
        return clapCountArr[target] > 0;
    }
}
