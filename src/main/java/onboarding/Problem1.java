package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkPage(int[] pages) {
        if (pages[0] - pages[1] != -1)
            return false;
        if (pages[0] < 1 || pages[1] > 400)
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

    private static int getBigNum(int[] pages) {
        int addNum = Math.max(getAddNum(pages[0]), getAddNum(pages[1]));
        int mulNum = Math.max(getMulNum(pages[0]), getMulNum(pages[1]));
        return Math.max(addNum, mulNum);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPage(pobi) || !checkPage(crong))
            return -1;
        int p = getBigNum(pobi);
        int c = getBigNum(crong);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}