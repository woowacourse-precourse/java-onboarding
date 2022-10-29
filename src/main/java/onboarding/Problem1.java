package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_high_num = maxScore(pobi);
        int crong_high_num = maxScore(crong);

        if(pobi_high_num>crong_high_num)
            answer = 1;
        else if (pobi_high_num<crong_high_num)
            answer = 2;
        else answer = 0;

        return answer;
    }
    public static int addEachDigit(int num){
        int first = num / 100;
        int second = (num%100) /10;
        int third = ((num%100) %10);
        return first + second + third;
    }

    public static int multiplyEachDigit(int num){
        int first = (num / 100) == 0 ? 1 : (num / 100);
        int second = (num%100) /10 == 0 ? 1 : (num%100) /10;
        int third = ((num%100) %10) == 0? 1 : ((num%100) %10);
        return first * second * third;
    }

    private static int maxAddOrMultiply(int num){
        return Math.max(addEachDigit(num), multiplyEachDigit(num));
    }

    private static int maxScore(List<Integer> list){
        return Math.max(maxAddOrMultiply(list.get(0)), maxAddOrMultiply(list.get(1)));
    }
}