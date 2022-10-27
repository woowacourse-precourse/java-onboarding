package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int raisePageLengthException(List<Integer> pobi, List<Integer> crong) {
        int pobiLength = pobi.get(1) - pobi.get(0);
        int crongLength = crong.get(1) - crong.get(0);

        if (pobiLength != 1 || crongLength != 1) {
            return 1;
        }
        
        return 0;
    }

}