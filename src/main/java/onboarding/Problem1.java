package onboarding;

import java.util.ArrayList;
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

        // pobi와 crong 페이지 값에 따른 최대 값 계산
        ArrayList<Integer> arrNumPobiLeft = new ArrayList<>();
        ArrayList<Integer> arrNumPobiRight = new ArrayList<>();
        ArrayList<Integer> arrNumCrongLeft = new ArrayList<>();
        ArrayList<Integer> arrNumCrongRight = new ArrayList<>();

        // While문 및 나누셈을 통한 페이지의 각 자리수 분리하기
        int numPL = pobiLeftPage ;
        int numPR = pobiRightPage ;
        int numCL = crongLeftPage ;
        int numCR = crongRightPage ;

        while ( numPL > 0 ) {
            arrNumPobiLeft.add(numPL%10);
            numPL /= 10;
        }

        while ( numPR > 0 ) {
            arrNumPobiRight.add(numPR%10);
            numPR /= 10;
        }

        while ( numCL > 0 ) {
            arrNumCrongLeft.add(numCL%10);
            numCL /= 10;
        }

        while ( numCR > 0 ) {
            arrNumCrongRight.add(numCR%10);
            numCR /= 10;
        }









        int answer = Integer.MAX_VALUE;
        return answer;
    }

}