package onboarding;

import java.util.List;

class Problem1 {


    private static boolean pageSequence;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiSize = pobi.size();
        int crongSize = crong.size();

        int pobiFirstNumber = pobi.get(0);
        int pobiSecondNumber = pobi.get(1);

        if (pobiSize !=2 || crongSize !=2){
            return -1;
        } else if (pobiFirstNumber + 1 != pobiSecondNumber){
            pageSequence = true;
            return -1;
        } else{
        int answer = Integer.MAX_VALUE;
        return answer;
        }
    }

}