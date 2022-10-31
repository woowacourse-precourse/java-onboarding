package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static boolean checkException(List<Integer> player){
        if(player.get(0) < 1 || player.get(1) < 1 || player.get(0) > 400 || player.get(1) > 400){
            return false;
        }
        if (player.get(0) + 1 != player.get(1)){
            return false;
        }
        return true;
    }
    public static List<Integer> splitPagenumber(Integer pagenumber){
        List<Integer> pageSplits = new ArrayList<>();
        while(pagenumber > 0){
            pageSplits.add(pagenumber%10);
            pagenumber /= 10;
        }
        return pageSplits;
    }
}