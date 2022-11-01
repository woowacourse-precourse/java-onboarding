package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong)) return -1;

        Integer pobiValue = getMaxCombination(pobi);
        Integer crongValue = getMaxCombination(crong);

        if(pobiValue > crongValue) return 1;
        if(pobiValue < crongValue) return 2;
        if(pobiValue == crongValue) return 0;

        return -1;
    }

    private static Integer getAddition(Integer page) {
        Integer result = 0;

        while(page > 0){
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    private static Integer getMultiplication(Integer page) {
        Integer result = 1;

        while(page > 0) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }

    private static Integer getMaxCombination(List<Integer> pages) {
        List<Integer> combinations = new ArrayList<>();

        combinations.add(getAddition(pages.get(0)));
        combinations.add(getMultiplication(pages.get(0)));

        combinations.add(getAddition(pages.get(1)));
        combinations.add(getMultiplication(pages.get(1)));

        return Collections.max(combinations);
    }

    private static boolean isException(List<Integer> pages){
        if(pages.size() != 2) return true;
        if(pages.get(0) < 1 || pages.get(1) < 1) return true;
        if(pages.get(0) > 400 || pages.get(1) > 400) return true;
        //연속된 페이지 검사
        if(pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0) return true;
        if((pages.get(1) - pages.get(0)) != 1) return true;
        return false;
    }
}