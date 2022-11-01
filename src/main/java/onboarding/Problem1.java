package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkPage(List<Integer> pages) {
        if (pages.get(0) - pages.get(1) != -1 || pages.get(0) < 1 || pages.get(1) > 400)
            return false;
        return true;
    }
    
    private static int getDigit(int num) {
        int digit = 0;
        while (num > 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }

    private static int getAddNum(int num) {
        int addNum = 0;
        for (int i = getDigit(num) - 1; i >= 0; i--) {
            int tens = (int)Math.pow(10, i);
            addNum += num / tens;
            num %= tens;
        }
        return addNum;
    }

    private static int getMulNum(int num) {
        int mulNum = 1;
        for (int i = getDigit(num) - 1; i >= 0; i--) {
            int tens = (int)Math.pow(10, i);
            mulNum *= num / tens;
            num %= tens;
        }
        return mulNum;
    }

    private static int getBigNum(List<Integer> pages) {
        int addNum = Math.max(getAddNum(pages.get(0)), getAddNum(pages.get(1)));
        int mulNum = Math.max(getMulNum(pages.get(0)), getMulNum(pages.get(1)));
        return Math.max(addNum, mulNum);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPage(pobi) || !checkPage(crong))
            return -1;
        int p = getBigNum(pobi);
        int c = getBigNum(crong);
        if (p == c)
            return 0;
        return p > c ? 1 : 2;
    }
}