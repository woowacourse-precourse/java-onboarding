package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if((isValidInput(pobi) && isValidInput(crong)) == false){
            return -1;
        }

        return 0;
    }

    public static boolean isValidInput(List<Integer> input){
        if((input.get(1) - input.get(0)) == 1){
            return true;
        }
        return false;
    }
}