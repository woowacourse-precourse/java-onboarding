package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = pobi.get(1);

        // 예외사항 작성
        if ( pobiLeftPage < 3 || crongLeftPage < 3 || pobiLeftPage > 397 || crongLeftPage > 397 ) {
            return -1;
        } else if ( pobiRightPage != pobiLeftPage + 1 || crongRightPage != crongLeftPage + 1) {
            return -1;
        } else if ( pobiRightPage%2 != 0 || crongRightPage%2 != 0 ) {
            return -1;
        } else if ( pobi.size() != 2 || crong.size() != 2 ){
            return -1;
        }




        int answer = Integer.MAX_VALUE;
        return answer;
    }

}