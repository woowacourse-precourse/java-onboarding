package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkCorrectOf(List<Integer> player){
        if(player.get(1) - player.get(0) != 1) return false;
        else if(player.get(0)==null || player.get(1) ==null) return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkCorrectOf(pobi) || !checkCorrectOf(crong)) return -1;
        return 0;
    }
}