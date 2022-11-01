package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!exceptionCheck(pobi) || !exceptionCheck(crong)){return -1;}

        int pobi_score = getScore(pobi);
        int crong_score = getScore(crong);

        if(pobi_score > crong_score) {return 1;}
        else if(pobi_score < crong_score) {return 2;}
        else {return 0;}
    }
    static int getScore(List<Integer> list) {
        int left_page = list.get(0);
        int right_page = list.get(1);
        int score = Math.max(calculateSum(left_page),calculateSum(right_page));
        score = Math.max(score,calculateMulti(left_page));
        score = Math.max(score,calculateMulti(right_page));
        return score;
    }

    static int calculateSum(int number) {
        int result = 0;
        while(number > 0){
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    static int calculateMulti(int number) {
        int result = 1;
        while(number > 0){
            result *= number % 10;
            number = number / 10;
        }
        return result;
    }

    static boolean exceptionCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) {return false;}
        if(left%2 == 0) {return false;}
        if(left < 1 || left > 400) {return false;}
        if(right <1 || right > 400) {return false;}
        return true;
    }
}