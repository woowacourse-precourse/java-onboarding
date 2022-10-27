package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (raisePageLengthException(pobi, crong) == 1){
            return answer = -1;
        }

        if (raisePageBoundException(pobi.get(0), crong.get(0)) == 1
                || raisePageBoundException(pobi.get(1), crong.get(1)) == 1) {
            return answer = -1;
        }

        return answer;
    }

    public static int raisePageLengthException(List<Integer> pobi, List<Integer> crong) {
        int pobiLength = pobi.get(1) - pobi.get(0);
        int crongLength = crong.get(1) - crong.get(0);

        if (pobiLength != 1 || crongLength != 1) {
            return 1;
        }

        return 0;
    }

    public static int raisePageBoundException(int pobiPage, int crongPage) {
        boolean pobiBound = (pobiPage < 1 || pobiPage > 400);
        boolean crongBound = (crongPage < 1 || pobiPage > 400);

        if (pobiBound == true || crongBound == true) {
            return 1;
        }
        return 0;
    }


}