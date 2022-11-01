package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int scoreOfPobi = getScore(pobi.get(0), pobi.get(1));
        int scoreOfCrong = getScore(crong.get(0), crong.get(1));

        if (isException(pobi.get(0), pobi.get(1))||isException(crong.get(0), crong.get(1))) return -1;

        if (scoreOfPobi > scoreOfCrong) return 1;
        else if (scoreOfPobi < scoreOfCrong) return 2;
        else return 0;
    }

    public static int getSum (int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int getMultiply (int num){
        int multiply = 1;
        while(num != 0){
            multiply *= num%10;
            num /= 10;
        }
        return multiply;
    }

    public static int getScore (int leftPageNum, int rightPageNum){
        int leftPageScore = getSum(leftPageNum)>getMultiply(leftPageNum) ? getSum(leftPageNum) : getMultiply(leftPageNum);
        int rightPageScore= getSum(rightPageNum)>getMultiply(rightPageNum) ? getSum(rightPageNum) : getMultiply(rightPageNum);
        int finalScore = leftPageScore>rightPageScore ? leftPageScore : rightPageScore;
        return finalScore;
    }

    public static boolean isException(int leftPageNum, int rightPageNum){
        if (leftPageNum%2 != 1) return true;
        if (leftPageNum < 1) return true;
        if (rightPageNum%2 != 0) return true;
        if (rightPageNum > 400) return true;
        if (rightPageNum - leftPageNum != 1) return true;
        return false;
    }
}