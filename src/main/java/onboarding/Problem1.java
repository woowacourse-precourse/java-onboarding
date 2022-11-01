package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private static boolean checkPage(int left, int right) {
        if (left < 1 || 400 < left || right < 1 || 400 < right)
            return false;
        if (left + 1 != right)
            return false;
        return left % 2 == 1 && right % 2 == 0;
    }
    private static boolean checkValid(List<Integer> pobi, List<Integer> crong) {
        return checkPage(pobi.get(0), pobi.get(1)) && checkPage(crong.get(0), crong.get(1));
    }

    static int getAddDigit(int val){
        int ret;

        ret = 0;
        while (val != 0){
            ret += val % 10;
            val /= 10;
        }
        return ret;
    }

    static int getMulDigit(int val){
        int ret;

        ret = 1;
        while (val != 0){
            ret *= val % 10;
            val /= 10;
        }
        return ret;
    }
    private static int getMaxVal(int left, int right) {
        int addDigit;
        int mulDigit;

        addDigit = max(getAddDigit(left), getAddDigit(right));
        mulDigit = max(getMulDigit(left), getMulDigit(right));
        return max(addDigit, mulDigit);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiVal;
        int crongVal;

        if (!checkValid(pobi, crong))
            return -1;
        pobiVal = getMaxVal(pobi.get(0), pobi.get(1));
        crongVal = getMaxVal(crong.get(0), crong.get(1));
        if (pobiVal > crongVal)
            return 1;
        if (pobiVal < crongVal)
            return 2;
        return 0;
    }
}