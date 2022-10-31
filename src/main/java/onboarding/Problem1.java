package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiNum=-1, crongNum=-1;

        //pobi의 큰 수 구하기
        for(int po:pobi){
            int sum=0,mul=1;
            while(po>0){
                sum+=po%10;
                mul*=po%10;
                po=po/10;
            }
            pobiNum=Math.max(pobiNum,Math.max(sum,mul));
        }

        //crong 큰 수 구하기
        for(int cr:crong){
            int sum=0,mul=1;
            while(cr>0){
                sum+=cr%10;
                mul*=cr%10;
                cr=cr/10;
            }
            crongNum=Math.max(crongNum,Math.max(sum,mul));
        }

        //포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
        if(pobiNum>crongNum)answer=1;
        else if(pobiNum<crongNum)answer=2;
        else answer=0;

        return answer;
    }
}