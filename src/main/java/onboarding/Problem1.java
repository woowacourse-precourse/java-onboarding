package onboarding;

import java.util.List;

class Problem1 {

    public static boolean check(List<Integer> pobi, List<Integer> crong) {
        if (!(1 <= pobi.get(0) && pobi.get(0) <= 400) || !(1 <= pobi.get(1) && pobi.get(1) <= 400)
                || !(1 <= crong.get(0) && crong.get(0) <= 400) || !(1 <= crong.get(1) && crong.get(1) <= 400)) {
            return false;
        }
        if (!(pobi.get(0) % 2 == 1 && pobi.get(1) % 2 == 0) || !(crong.get(0) % 2 == 1 && crong.get(1) % 2 == 0)) {
            return false;
        }
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return false;
        }
        return true;
    }

    public static int getValue(int value) {
        int sum = 0, mul = 1;
        while (value > 0) {
            mul *= value % 10;
            sum += value % 10;
            value /= 10;
        }
        return Math.max(sum, mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean flag = check(pobi, crong);
        if (flag) {
            int pobiValue = Math.max(getValue(pobi.get(0)), getValue(pobi.get(1)));
            int crongValue = Math.max(getValue(crong.get(0)), getValue(crong.get(1)));
            if (flag) {
                if (pobiValue > crongValue) {
                    return 1;
                } else if (pobiValue < crongValue) {
                    return 2;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}