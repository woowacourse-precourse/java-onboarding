package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(isInvalidData(pobi) && isInvalidData(crong))){
            return -1;
        }
        int pobiScore = biggestScoreByPageNum(pobi.get(0), pobi.get(1));
        int crongScore = biggestScoreByPageNum(crong.get(0), crong.get(1));

        return winner(pobiScore, crongScore);
    }

    public static int winner(int pobiScore, int crongScore){
        if(pobiScore > crongScore){
            return 1;
        }
        else if(pobiScore < crongScore){
            return 2;
        }
        else {
            return 0;
        }
    }

    public static boolean isInvalidData(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);
        return left + 1 == right;
    }

    public static int biggestScoreByPageNum(int leftPageNum, int rightPageNum){
        int leftScore = toScore(leftPageNum);
        int rightScore = toScore(rightPageNum);
        return leftScore > rightScore ? leftScore : rightScore;
    }
    public static int toScore(int pageNum){
        int sum = 0;
        int mul = 1;

        int num = pageNum;
        for(; num > 0; num /= 10){
            int digit = num % 10;
            sum += digit;
            mul *= digit;
        }
        if (sum > mul){
            return sum;
        }
        else{
            return mul;
        }
    }
}