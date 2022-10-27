package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

       
        return answer;
    }

    static int PageCheck(int page){
        int MAX_PAGE_ADD =0;
        int MAX_PAGE_MUL =1;

        while(page!=0){
            MAX_PAGE_ADD+=page%10;
            MAX_PAGE_MUL*=page%10;
            page/=10;
        }
        return Math.max(MAX_PAGE_ADD,MAX_PAGE_MUL);
    }
}