package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiValue = Math.max(calculate(pobi.get(0)), calculate(pobi.get(1)));
        int crongValue = Math.max(calculate(crong.get(0)), calculate(crong.get(1)));

        if (!(isValidPage(pobi)) || !(isValidPage(crong))) {
            return -1;
        }

        if ( pobiValue > crongValue) {
            return 1;
        }

        if ( pobiValue < crongValue) {
            return 2;
        }

        if( pobiValue == crongValue) {
            return 0;
        }

        return -1;
    }

    static int calculate(Integer page) {
        int value = 0;
        int plus = 0;
        int multiple = 1;

        while (page != 0 ) {
            plus += page % 10;
            multiple *= page % 10;
            page /= 10;
        }

        value = Math.max(plus, multiple);

        return value;
    }

    static boolean isValidPage(List<Integer> page) {
        int l = page.get(0);
        int r = page.get(1);

        if (l <= 1 || r > 400 || l >= 400) {
            return false;
        }

        if (r - l != 1) {
            return false;
        }

        if (l >= r) {
            return false;
        }

        return true;
    }
}