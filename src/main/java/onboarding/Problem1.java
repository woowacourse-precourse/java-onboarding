package onboarding;

import java.util.List;

class Problem1 {
    public static int getCompare(int num){
        int add=0;
        int multiply=1;
        while(num > 0) {
            add+=num %10;
            multiply*=num %10;
            num /= 10;
        }
        return Math.max(add, multiply);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiL=pobi.get(0).intValue();
        int pobiR=pobi.get(1).intValue();
        int crongL=crong.get(0).intValue();
        int crongR=crong.get(1).intValue();

        if(Math.abs(pobiL-pobiR)!=1 || Math.abs(pobiL-pobiR)!=1) {
            answer = -1;
        }else {
            int pobiMax = Math.max(getCompare(pobiL), getCompare(pobiR));
            int crongMax = Math.max(getCompare(crongL), getCompare(crongR));
            if (pobiMax > crongMax) answer=1;
            else if (pobiMax < crongMax) answer=2;
            else answer=0;
        }
        return answer;
    }
}