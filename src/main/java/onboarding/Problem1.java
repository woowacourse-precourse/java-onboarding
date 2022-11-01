package onboarding;

import java.util.List;

class Problem1 {
    static int plus(int a){
        int num=0;
        while(a>0){
            num+=a%10;
            a/=10;
        }
        return num;
    }
    static int multiply(int a){
        int num=1;
        while(a>0){
            num*=a%10;
            a/=10;
        }
        return num;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0)%2==1 && pobi.get(1)%2==0 && pobi.get(1)==pobi.get(0)+1 && crong.get(0)%2==1 && crong.get(1)%2==0 && crong.get(1)==crong.get(0)+1){
            int p=Math.max(Math.max(plus(pobi.get(0)),plus(pobi.get(1))),Math.max(multiply(pobi.get(0)),multiply(pobi.get(1))));
            int c=Math.max(Math.max(plus(crong.get(0)),plus(crong.get(1))),Math.max(multiply(crong.get(0)),multiply(crong.get(1))));
            if(p>c) answer = 1;
            else if(c>p) answer = 2;
            else answer = 0;
        }
        else answer = -1;
        return answer;
    }
}