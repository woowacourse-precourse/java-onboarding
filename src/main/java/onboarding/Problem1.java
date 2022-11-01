package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    // 각 자리의 숫자 더하는 메서드
    public static int sumNum(int num){
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    // 각 자리의 숫자 곱하는 메서드
    public static int mulNum(int num){
        int mul=1;
        while(num>0){
            if(mul!=0){
                mul *= num%10;
            }
            num /= 10;
        }
        return mul;
    }
}