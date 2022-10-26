package onboarding;

import java.util.List;

class calculate{
    public static int sumOfPageNumbers(int pageNumber){
        int sum=0;
        while(pageNumber>0){
            sum+=pageNumber%10;
            pageNumber/=10;
        }
        return sum;
    }
    public static int mulOfPageNumbers(int pageNumber){
        int mul=1;
        while(pageNumber>0){
            mul*=pageNumber%10;
            pageNumber/=10;
        }
        return mul;
    }
}
class findMax{
    public static int findMaxValue(int left, int right){
        int leftMaxValue=calculate.sumOfPageNumbers(left)>calculate.mulOfPageNumbers(left)?calculate.sumOfPageNumbers(left):calculate.mulOfPageNumbers(left);
        int rightMaxValue=calculate.sumOfPageNumbers(right)>calculate.mulOfPageNumbers(right)?calculate.sumOfPageNumbers(right):calculate.mulOfPageNumbers(right);
        return leftMaxValue>rightMaxValue?leftMaxValue:rightMaxValue;
    }
}
class findWinner{
    public static int winner(int pobiMaxNumber, int crongMaxNumber){
        if(pobiMaxNumber==crongMaxNumber){return 0;}
        return pobiMaxNumber>crongMaxNumber?1:2;
    }
}
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}