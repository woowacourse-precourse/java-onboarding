package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMaxNum=0;
        int crongMaxNum=0;

        if(pobi.size()<2 || crong.size()<2 || pobi.size()>3 || crong.size()>3){
            return -1;
        }
        if(pobi.get(0)<1 || pobi.get(1)>400 || (pobi.get(0)+1 != pobi.get(1))){
            return -1;
        }

        

        return answer;
    }
}