package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean check = checkException(pobi);
        if (!check) return -1;

        int pobiMax = getMaxValue(pobi);
        int crongMax = getMaxValue(crong);

        if (pobiMax > crongMax) return 1;
        else if (pobiMax < crongMax) return 2;
        else return 0;
    }

    private static int getMaxValue(List<Integer> choice) {
        int maxVal = 0;
        int sum = 0;
        int mul = 1;
        for (Integer page : choice) {
            while (page != 0) {
                int res = page % 10;
                page = page / 10;
                sum += res;
                mul *= res;
            }
            int temp = Math.max(sum, mul);
            maxVal = Math.max(maxVal, temp);
        }
        return maxVal;
    }

    private static boolean checkException(List<Integer> choice) {
        int first = choice.get(0);
        int second = choice.get(1);
        int diff = second - first;
        if (first < 1 || first > 400) return false;
        if (diff != 1) return false;
        return true;
    }
}