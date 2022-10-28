package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isSuccessivePage(List<Integer> pagenumber){
        if (pagenumber.get(1) - pagenumber.get(0)!=1){
            return false;
        }else{
            return true;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isSuccessivePage(pobi)==false||isSuccessivePage(crong)==false){
            answer=-1;
        }


        return answer;
    }
}