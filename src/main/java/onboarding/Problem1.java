package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!(checkValid(pobi) && checkValid(crong))) {
            return -1;
        }
        int pobiSum = Math.max(getSum(pobi.get(0)), getSum(pobi.get(1)));
        int crongSum = Math.max(getSum(crong.get(0)), getSum(crong.get(1)));

        int pobiMult = Math.max(getMulti(pobi.get(0)), getMulti(pobi.get(1)));
        int crongMult = Math.max(getMulti(crong.get(0)), getMulti(crong.get(1)));

        int pobiScore = Math.max(pobiSum, pobiMult);
        int crongScore = Math.max(crongSum, crongMult);


        if (pobiScore > crongScore) {
            return 1;
        } else if (crongScore > pobiScore) {
            return 2;
        } else {
            return 0;
        }
    }

    static boolean checkValid(List<Integer> score) {
        int firstIndex = score.get(0);
        int secondIndex = score.get(1);

        if (score.size() != 2) {
            return false;
        } else if (firstIndex + 1 != secondIndex) {
            return false;
        }
        return firstIndex % 2 != 0 && secondIndex % 2 == 0;
    }

    static int getSum(int score) {
        int sum = 0;
        while (score != 0) {
            sum += score % 10;
            score /= 10;
        }
        return sum;
    }


    static int getMulti(int score) {
        int mult = 1;
        while (score != 0) {
            mult *= score % 10;
            score /= 10;
        }
        return mult;
    }


}