package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (notInOnePage(pobi) || notInOnePage(crong)) return -1;
        if (isOddAndEven(pobi) || isOddAndEven(crong)) return -1;
        if (isInBookRange(pobi) || isInBookRange(crong)) return -1;
        int pobiMax = getMaxPage(pobi.get(0)) > getMaxPage(pobi.get(0)) ? getMaxPage(pobi.get(0)) : getMaxPage(pobi.get(0));
        int crongMax = getMaxPage(crong.get(0)) > getMaxPage(crong.get(0)) ? getMaxPage(crong.get(0)) : getMaxPage(crong.get(0));
        if (pobiMax == crongMax) return 0;
        else if (pobiMax > crongMax) return 1;
        else return 2;
    }

    public static boolean isInBookRange(List<Integer> intList) {
        return (intList.get(0) < 3 || intList.get(1) > 398) ? true : false;
    }

    public static boolean isOddAndEven(List<Integer> intList) {
        return (intList.get(0) % 2 == 0 || intList.get(1) % 2 == 1) ? true : false;
    }

    public static boolean notInOnePage(List<Integer> intList) {
        return (intList.get(1) - intList.get(0) != 1) ? true : false;
    }

    public static int getMaxPage(int page) {
        int plus = 0;
        int multi = 1;
        String pageNums = Integer.toString(page);

        for(char pageNum : pageNums.toCharArray()) {
            int num = Character.getNumericValue(pageNum);
            plus += num;
            multi *= num;
        }
        return (plus > multi) ? plus : multi;
    }
}