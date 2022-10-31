package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxScore  = getPlayerMaxScore(pobi);
        int crongMaxScore = getPlayerMaxScore(crong);

        if(pobiMaxScore > crongMaxScore){
            return 1;
        }
        else if(crongMaxScore > pobiMaxScore){
            return 2;
        }
        else{
            return 0;
        }
    }

    public static int sumDigit(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int multiplyDigit(int page){
        int multi = 1;
        while(page > 0){
            multi *= page % 10;
            page /= 10;
        }
        return multi;
    }

    public static int getMaxScoreOfMultiAndSum(int page){
        int multiScore = multiplyDigit(page);
        int sumScore = sumDigit(page);
        return Math.max(multiScore, sumScore);
    }

    public static int getPlayerMaxScore(List<Integer> pages){
        int leftMaxScore = getMaxScoreOfMultiAndSum(pages.get(0));
        int rightMaxScore = getMaxScoreOfMultiAndSum(pages.get(1));
        return Math.max(leftMaxScore, rightMaxScore);
    }

}