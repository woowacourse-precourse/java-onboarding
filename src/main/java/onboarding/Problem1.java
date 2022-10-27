package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore= 0;
        int crongScore= 0;

        for(int i=0; i<2; i++){
            int num = pobi.get(i);
            pobiScore = pobiScore>plus(num)? pobiScore: plus(num)>multiply(num)? plus(num) :multiply(num);
            num = crong.get(i);
            crongScore = crongScore > plus(num)? crongScore: plus(num)>multiply(num)? plus(num) :multiply(num);
        }

        int answer = pobiScore>crongScore? 1: pobiScore==crongScore? 0:2;
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