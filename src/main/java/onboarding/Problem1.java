package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isInvalidPage(pobi.get(0), pobi.get(1)) || isInvalidPage(crong.get(0), crong.get(1))) {
            return -1;
        }

        int pobiValue = getMaxValue(pobi);
        int crongValue = getMaxValue(crong);

        if (pobiValue > crongValue) {
            return 1;
        }
        if (pobiValue < crongValue) {
            return 2;
        }
        return 0;

    }

    public static int getMaxValue(List<Integer> pageList) {
        List<Integer> calculateList = new ArrayList<>();
        pageList.forEach(
                page -> getCalculateList(calculateList, page)
        );
        return Collections.max(calculateList);
    }

    private static void getCalculateList(List<Integer> calculateList, Integer page) {
        int sumResult = 0;
        int mulResult = 1;
        String pageString = page.toString();

        for (int i = 0; i < pageString.length(); i++) {
            sumResult += Character.getNumericValue(pageString.charAt(i));
            mulResult *= Character.getNumericValue(pageString.charAt(i));
        }
        calculateList.add(sumResult);
        calculateList.add(mulResult);
    }

    public static boolean isInvalidPage(int left, int right) {
        return (Math.abs(left - right) != 1) || (left % 2 != 1) || (right % 2 != 0);
    }
}