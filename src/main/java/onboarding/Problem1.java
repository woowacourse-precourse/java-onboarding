package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1
            || pobi.get(0) == 1 || pobi.get(0) == 400 || pobi.get(1) == 1 || pobi.get(1) == 400
            || crong.get(0) == 1 || crong.get(0) == 400 || crong.get(1) == 1 || crong.get(1) == 400) {
            return -1;
        }

        int pobiMax = 0;
        int crongMax = 0;
        for (int i = 0; i < pobi.size(); i++) {
            int tmp1 = Math.max(add(pobi.get(i)), mul(pobi.get(i)));
            pobiMax = Math.max(tmp1, pobiMax);
        }

        for (int i = 0; i < crong.size(); i++) {
            int tmp2 = Math.max(add(crong.get(i)), mul(crong.get(i)));
            crongMax = Math.max(tmp2, crongMax);
        }

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int add(int num) {
        int result = 0;
        int numLength = String.valueOf(num).length();
        for (int i = 1; i <= numLength; i++) {
            result += num%10;
            num /= 10;
        }
        return result;
    }

    public static int mul(int num) {
        int result = 1;
        int numLength = String.valueOf(num).length();
        for (int i = 1; i <= numLength; i++) {
            result *= num%10;
            num /= 10;
        }
        return result;
    }
}