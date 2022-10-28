package onboarding;

import java.util.List;

class Problem1 {
    public int addEachDigitOfPageNum(int pageNum){
        int sumOfEachDigit=0;
        while(pageNum>0){
            sumOfEachDigit+=pageNum%10;
            pageNum/=10;
        }
        return sumOfEachDigit;
    }
    public int multiplyEachDigitOfPageNum(int pageNum){
        int productOfEachDigit=1;
        while(pageNum>0){
            productOfEachDigit*=pageNum%10;
            pageNum/=10;
        }
        return productOfEachDigit;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}