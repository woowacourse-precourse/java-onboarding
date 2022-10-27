package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1){
            return -1;
        }

        int pobiMax=Math.max(findMax(pobi.get(0)),findMax(pobi.get(1)));
        int crongMax=Math.max(findMax(crong.get(0)),findMax(crong.get(1)));

        if(pobiMax>crongMax){
            answer=1;
        }
        else if(crongMax>pobiMax){
            answer=2;
        }
        else{
            answer=0;
        }

        return answer;
    }

    public static int findMax(Integer num){
        //각 자리 수 구하기
        int add=0;
        int mul=1;

        while(num>0){
            int left=num%10;
            add+=left;
            mul*=left;
            num/=10;
        }
        return Math.max(add,mul);
    }
}