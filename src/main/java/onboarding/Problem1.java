package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeft = pobi.get(0), pobiRight = pobi.get(1);
        int crongLeft = crong.get(0), crongRight = crong.get(1);

        int pobiScore = Math.max(getBigNumberByPage(pobiLeft), getBigNumberByPage(pobiRight));
        int crongScore = Math.max(getBigNumberByPage(crongLeft), getBigNumberByPage(crongRight));

        System.out.println(pobiScore);
        System.out.println(crongScore);

        return 0;
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