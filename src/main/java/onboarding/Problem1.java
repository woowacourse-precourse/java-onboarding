package onboarding;

import java.util.List;

class Problem1 {
    public static int myMultiply(int n) {
        int result = 1;
        while (n != 0) {
            result = result * (n % 10);
            n /= 10;
        }
        return result;
    }

    public static int myAdd(int n) {
        int result = 0;
        while (n != 0) {
            result = result + (n % 10);
            n /= 10;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (Math.abs(pobi.get(0) - pobi.get(1)) != 1 || Math.abs(crong.get(0) - crong.get(1)) != 1) {
            return -1;
        } else {
            int pobiMax = Math.max(Math.max(myMultiply(pobi.get(0)), myAdd(pobi.get(1))),
                    Math.max(myMultiply(pobi.get(1)), myAdd(pobi.get(1))));
            int crongMax = Math.max(Math.max(myMultiply(crong.get(0)), myAdd(crong.get(1))),
                    Math.max(myMultiply(crong.get(1)), myAdd(crong.get(1))));

            if (pobiMax > crongMax)
                return 1;
            else if (pobiMax < crongMax)
                return 2;
            else
                return 0;
        }
    }
}