package onboarding;

import java.util.List;

class Problem1 {


    private static boolean pageSequence;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiFirstNumber = pobi.get(0);
        int pobiSecondNumber = pobi.get(1);
        int crongFirstNumber = pobi.get(0);
        int crongSecondNumber = pobi.get(1);

        if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber){
            pageSequence = false;
            return -1;
        } else{


        int answer = Integer.MAX_VALUE;
        return answer;
        }
    }

}