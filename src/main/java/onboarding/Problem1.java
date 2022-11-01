package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        List<Integer> maxValue = new ArrayList<>();
        if(checkValid(pobi) == 1){
            return -1;
        }

        List<Integer> maxValue2 = new ArrayList<>();
        if(checkValid(pobi) == 1){
            return -1;
        }


        return answer;
    }

    private static int checkValid(List<Integer> pages){
        int res = 0;
        if(pages.get(0)+1 == pages.get(1)){
            return 0;
        }
        else {
            return 1;
        }
    }

}