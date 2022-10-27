package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeft = pobi.get(0), pobiRight = pobi.get(1);
        int crongLeft = crong.get(0), crongRight = crong.get(1);

        if (pobiLeft == 1 || crongLeft == 1 || pobiRight == 400 || crongRight == 400) {
            return -1;
        }
        if (pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1) {
            return -1;
        }

        int pobiScore = Math.max(getBigNumberByPage(pobiLeft), getBigNumberByPage(pobiRight));
        int crongScore = Math.max(getBigNumberByPage(crongLeft), getBigNumberByPage(crongRight));

        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }

    public static int getBigNumberByPage(int page) {
        int addSum = 0, multiplySum = 1;

        while (page > 0) {
            int mod = page % 10;
            addSum += mod;
            multiplySum *= mod;
            page /= 10;
        }

        int bigNumber = Math.max(addSum, multiplySum);
        return bigNumber;
    }
}