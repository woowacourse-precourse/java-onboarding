package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLpage = pobi.get(0);
        int pobiRpage = pobi.get(1);
        int crongLpage = crong.get(0);
        int crongRpage = crong.get(1);

        if(pobiRpage-pobiLpage==1 && crongRpage-crongLpage==1){
            int answer;
            Problem1 P = new Problem1();
            int pobiMax = Math.max(P.findPageMaxNum(pobiLpage),P.findPageMaxNum(pobiRpage));
            int crongMax = Math.max(P.findPageMaxNum(crongLpage),P.findPageMaxNum(crongRpage));
            answer = pobiMax!=crongMax?pobiMax>crongMax?1:2:0;
            return answer;
        }
        else return -1;
    }

    public int findPageMaxNum(int pageNum){
        int plus = 0;
        int multi = 1;
        while(pageNum > 0) {
            plus += pageNum % 10;
            multi *= pageNum % 10;
            pageNum /= 10;
        }
        int maxNum = Math.max(plus, multi);

        return maxNum;
    }

}