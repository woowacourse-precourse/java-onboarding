package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] clap = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            clap[i] = clap[i - 1] + getClapCount(i);
        }
        return clap[number];
    }

    /**
     * @param number
     * @return 숫자 number 에 포함된 3,6,9의 수
     */
    private static int getClapCount(int number) {
        int share = 0, result = 0;
        while (number > 0) {
            share = number % 10;
            if (share == 3 || share == 6 || share == 9) {
                result++;
            }
            number /= 10;
        }
        return result;
    }
}