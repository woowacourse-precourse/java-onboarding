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
  //각 자리의 더한 값들 비교
    public static int maxSum(int num){
        int max=0;
        if((num+1)%10 != 0){
            max=sumNum(num+1);
        }else {
            max=sumNum(num);
        }
        return max;
    }
    //각 자리의 곱한 값들 비교
    public static int maxMul(int num){
        int max=1;
        if((num+1)%10 != 0){
            max=mulNum(num+1);
        }else{
            max=mulNum(num);
        }
        return max;
    }
}
