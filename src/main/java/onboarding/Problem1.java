package onboarding;

import java.util.List;

class Problem1 {


    private static boolean pageSequence;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        int pobiFirstNumber = pobi.get(0);
        int pobiSecondNumber = pobi.get(1);

        int crongFirstNumber = pobi.get(0);
        int crongSecondNumber = pobi.get(1);

        if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber){
            pageSequence = false;
            answer = -1;
        }

        int pobiMaxValue = 0;
        int crongMaxValue = 0;

        // 자리수 확인




        answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int numberLength(int number){
        int length = (int)(Math.log10(number)+1);
        return length;
    }


}