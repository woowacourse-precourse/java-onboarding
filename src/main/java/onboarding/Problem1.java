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

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}