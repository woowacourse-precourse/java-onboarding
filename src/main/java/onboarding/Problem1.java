package onboarding;

import java.util.List;
import java.lang.Math;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPageError(pobi) || checkPageError(crong))
            return -1;
        Integer MaxNumberOfPobi = getMaxNumber(pobi);
        Integer MaxNumberOfCrong = getMaxNumber(crong);
        return MaxNumberOfPobi.compareTo(MaxNumberOfCrong);
    }
    public static boolean checkPageError(List<Integer> pages){
        if (pages.get(0) + 1 == pages.get(1))
            return false;
        else
            return true;
    }
    public static int getMaxNumber(List<Integer> pages){
        int max = 0;
        for (int page : pages){
            max = Math.max(max, getAddedNumber(page));
            max = Math.max(max, getMultipliedNumber(page));
        }
        return max;
    }
    public static int getAddedNumber(int pageNumber){
        int addedNumber = 0;
        while (pageNumber != 0){
            addedNumber += pageNumber % 10;
            pageNumber /= 10;
        }
        return addedNumber;
    }
    public static int getMultipliedNumber(int pageNumber){
        int multipliedNumber = 1;
        while (pageNumber != 0){
            multipliedNumber *= pageNumber % 10;
            pageNumber /= 10;
        }
        return multipliedNumber;
    }
}