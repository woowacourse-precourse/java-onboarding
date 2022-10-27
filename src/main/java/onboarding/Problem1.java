package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;
        return answer;
    }
    static public int plus(int num){
        int sum= 0;
        while(num>0){
            sum += num%10;
            num/= 10;
        }
        return sum;
    }
    static public int multiply(int num){
        int sum =1;
        while(num>0){
            sum *= num%10;
            num/= 10;
        }
        return sum;
    }
}