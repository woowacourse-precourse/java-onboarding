package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)-pobi.get(0)==1 && crong.get(1)-crong.get(0)==1){
            int answer;
            Problem1 P = new Problem1();
            int pobiMax = P.maxNum(pobi);
            int crongMax = P.maxNum(crong);
            answer = pobiMax!=crongMax?pobiMax>crongMax?1:2:0;
            return answer;
        }
        else return -1;
    }

    public int maxNum(List<Integer> list){
        int Max = 0;
        for (int pageNum : list) {
            int plus = 0;
            int multi = 1;
            while (pageNum > 0) {
                plus += pageNum % 10;
                multi *= pageNum % 10;
                pageNum /= 10;
            }
            Max = Math.max(Max, plus);
            Max = Math.max(Max, multi);
        }

        return Max;

    }
}