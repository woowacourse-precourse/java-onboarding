package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (checkInput(pobiLeft, pobiRight) || checkInput(crongLeft, crongRight))
            return -1;

        int pobiMaxScore = getMaxScore(List.of(add(pobiLeft), add(pobiRight), multiply(pobiLeft), multiply(pobiRight)));
        int crongMaxScore = getMaxScore(List.of(add(crongLeft), add(crongRight), multiply(crongLeft), multiply(crongRight)));

        if (pobiMaxScore > crongMaxScore)
            return 1;
        else if (pobiMaxScore < crongMaxScore)
            return 2;
        else
            return 0;
    }

    private static boolean checkInput(int left, int right){
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