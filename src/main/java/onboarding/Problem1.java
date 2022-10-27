package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!Exception(pobi.get(0), pobi.get(1)) || !Exception(crong.get(0), crong.get(1))) {
            answer = -1;
        }
        return answer;
    }

    public static boolean Exception(int page1, int page2){
        if(page1<=1 || page1>=399){
            return false;
        }else if(page1!=page2-1){
            return false;
        }else{
            return true;
        }
    }
}