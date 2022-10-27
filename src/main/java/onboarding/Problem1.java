package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore =0;
        int crongScore = 0;

        for(int i=0;i<pobi.size();i++){
            String pobiPage = String.valueOf(pobi.get(i));
            pobiScore = Math.max(pobiScore,findMaxNum(pobiPage));

            String crongPage = String.valueOf(crong.get(i));
            crongScore = Math.max(crongScore,findMaxNum(crongPage));
        }

        return answer;
    }

    public static int findMaxNum(String page){
        int add = page.charAt(0)-'0';
        int multiple = page.charAt(0)-'0';

        for(int i=1;i<page.length();i++){
            add += page.charAt(i)-'0';
            multiple *= page.charAt(i)-'0';
        }

        return Math.max(add, multiple);
    }
}