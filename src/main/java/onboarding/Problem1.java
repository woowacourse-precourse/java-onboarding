package onboarding;

import java.util.List;

class Problem1 {

    static final int INVALID = -1;
    static final int DRAW = 0;
    static final int POBI_WINS = 1;
    static final int CRONG_WINS = 2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(invaild(pobi) || invaild(crong)) return INVALID;
        
        int pobiScore = getMax(pobi);
        int crongScore = getMax(crong);

        if(pobiScore == crongScore) return DRAW;
        else if (pobiScore > crongScore) return POBI_WINS;
        else return CRONG_WINS;
    }

    public static int getSumOfPageDigits(int num){
        int sum = 0;

        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public static int getProductOfPageDigits(int num){
        int product = 1;

        while(num > 0){
            product *= num % 10;
            num /= 10;
        }

        return product;
    }

    public static int getMax(List<Integer> list){
        int page = list.get(0);

        int score = Math.max(getSumOfPageDigits(page), getProductOfPageDigits(page));

        page += 1;

        score = Math.max(score, getSumOfPageDigits(page));
        score = Math.max(score, getProductOfPageDigits(page));

        return score;
    }

    public static boolean invaild(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) return true;
        if(left%2 == 0) return true;
        if(outOfBound(left) || outOfBound(right)) return true;
        return false;
    }

    public static boolean outOfBound(int num){
        if(num >= 1 && num <= 400) return false;
        return true;
    }
}