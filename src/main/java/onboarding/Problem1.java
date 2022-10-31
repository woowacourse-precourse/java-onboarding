package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


        if(pobimax > crongmax)
            return 1;
        else if (pobimax == crongmax)
            return 0;
        else
            return 2;

    }



}