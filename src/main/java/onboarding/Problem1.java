package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isSuccessiveInt(pobi) && isSuccessiveInt(crong)) {

        }
        return -1;
    }

    private static boolean isSuccessiveInt(List<Integer> pageIntegerList) {
        return pageIntegerList.get(1) == pageIntegerList.get(0) + 1;
    }
}