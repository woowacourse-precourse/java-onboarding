package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getPlus(Integer pageNumber) {
        int value = 0;
        while(pageNumber>0) {
            value += pageNumber%10;
            pageNumber /= 10;
        }
        return value;
    }

    private static int getMul(Integer pageNumber) {
        int value = 1;
        while(pageNumber>0) {
            value *= pageNumber%10;
            pageNumber /= 10;
        }
        return value;
    }

    private static int getMaxValue(int left, int right) {
        int leftPlus = getPlus(left);
        int leftMul = getMul(left);
        int rightPlus = getPlus(right);
        int rightMul = getMul(right);

        Integer valueArr[] = {leftPlus, leftMul, rightPlus, rightMul};
        Arrays.sort(valueArr, Collections.reverseOrder());
        return valueArr[0];
    }

    private static boolean isPageRange(int leftPage, int rightPage) {
        if (leftPage<=1 || rightPage>=400) {
            return false;
        }
        return true;
    }
}