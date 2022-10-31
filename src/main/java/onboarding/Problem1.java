package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkException(pobi) == false || checkException(crong) == false){
            return -1;
        }
        int answer;
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
    
}