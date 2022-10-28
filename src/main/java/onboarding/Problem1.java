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
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}