package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        List<Integer> maxValue = new ArrayList<>();
        if(checkValid(pobi) == 1){
            return -1;
        }
        int pMax = calculateMax(pobi, maxValue);

        List<Integer> maxValue2 = new ArrayList<>();
        if(checkValid(pobi) == 1){
            return -1;
        }
        int cMax = calculateMax(crong, maxValue2);

        int answer = (pMax > cMax) ? 1 : ((cMax > pMax) ? 2 : 0);
        return answer;
    }

    private static int calculateMax(List<Integer> pages, List<Integer> maxValue) {
        for(int data : pages){
            int hundreds = data/100;
            int tens = data%100/10;
            int units = data%10;
            int plus = hundreds+tens+units;
            int multiple = ((hundreds > 0) ? hundreds*tens*units : tens*units);

            Integer max = (plus > multiple) ? plus : ((multiple > plus) ? multiple : plus);
            maxValue.add(max);
        }
        int resultMax = Collections.max(maxValue);

        return resultMax;
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