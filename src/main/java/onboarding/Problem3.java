package onboarding;

public class Problem3 {
    /**
     * 기능목록 :
     * <p>
     * 1부터 number까지 자리수 하나하나가 3, 6, 9를 가지고 있는지 검사 한 후
     * 가지고있으면 clapCount += 1
     */

    public static int solution(int number) {
        int clapCount = 0;

        for (int i = 1; i <= number; i++) {
            int digit = i;

            clapCount = getClapCount(clapCount, digit);
        }
        return clapCount;
    }

    private static int getClapCount(int clapCount, int digit) {
        while (digit != 0) {
            if (digit % 10 == 3 || digit % 10 == 6 || digit % 10 == 9)
                clapCount += 1;

            digit /= 10;
        }
        return clapCount;
    }

}
