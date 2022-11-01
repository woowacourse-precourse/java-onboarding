package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int RADIX = 10;
    static final int LEFT_PAGE_BOUNDARY = 1;
    static final int RIGHT_PAGE_BOUNDARY = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isPageRange(pobi.get(LEFT), pobi.get(RIGHT)) || !isPageRange(crong.get(LEFT), crong.get(RIGHT))) {
            return -1;
        }
        int maxValuePobi = getMaxValue(pobi.get(LEFT), pobi.get(RIGHT));
        int maxValueCrong = getMaxValue(crong.get(LEFT), crong.get(RIGHT));

        if (maxValuePobi>maxValueCrong) {
            return 1;
        } else if (maxValuePobi<maxValueCrong){
            return 2;
        }
        return 0;
    }

    private static int getPlus(Integer pageNumber) {
        int value = 0;
        while(pageNumber>0) {
            value += pageNumber%RADIX;
            pageNumber /= RADIX;
        }
        return value;
    }

    private static int getMul(Integer pageNumber) {
        int value = 1;
        while(pageNumber>0) {
            value *= pageNumber%RADIX;
            pageNumber /= RADIX;
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
        if (leftPage<=LEFT_PAGE_BOUNDARY || rightPage>=RIGHT_PAGE_BOUNDARY) {
            return false;
        }
        if (leftPage%2!=1 || rightPage%2!=0) {
            return false;
        }
        if (rightPage-leftPage!=1) {
            return false;
        }
        return true;
    }
}