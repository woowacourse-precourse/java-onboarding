package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiL = pobi.get(0);
        int pobiR = pobi.get(1);
        int crongL = crong.get(0);
        int crongR = crong.get(1);

        if (inputValidation(pobiL, pobiR) || inputValidation(crongL, crongR))
            return -1;

        int pMax = getMaxScore(List.of(add(pobiL), add(pobiR), multiply(pobiL), multiply(pobiR)));
        int cMax = getMaxScore(List.of(add(crongL), add(crongR), multiply(crongL), multiply(crongR)));

        if (pMax > cMax)
            return 1;
        else if (pMax < cMax)
            return 2;
        else
            return 0;
    }

    private static boolean inputValidation(int left, int right){
        if (left < 1 || left > 400 || right < 1 || right > 400)
            return true;
        if (left % 2 == 0 || right % 2 == 1)
            return true;
        return right - left != 1;
    }

    private static int add(int num){
        int result = 0;
        while (num > 0){
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    private static int multiply(int num){
        int result = 1;
        while (num > 0){
            result *= (num % 10);
            num /= 10;
        }
        return result;
    }

    private static int getMaxScore(List<Integer> scores){
        int maxScore = Integer.MIN_VALUE;
        for (Integer score : scores){
            if (maxScore < score)
                maxScore = score;
        }
        return maxScore;
    }

}