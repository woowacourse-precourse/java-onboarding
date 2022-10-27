package onboarding;

import java.util.Iterator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 포비와 크롱의 리스트에 들어있는 값을 넣을 배열
        int[] pobiPage = new int[2];
        int[] crongPage = new int[2];

        // 포비와 크롱의 리스트에 들어있는 값을 배열에 넣음
        Iterator<Integer> pobiItr = pobi.iterator();
        Iterator<Integer> crongItr = pobi.iterator();

        for(int i=0; i<pobiPage.length; i++){
            pobiPage[i] = pobiItr.next();
            crongPage[i] = crongItr.next();
        }

        // 예외 처리
        boolean isException = isException(pobiPage, crongPage);
        if(isException) return -1;

        // 포비의 계산결과 넣음

        // 크롱의 계산결과 넣음

        // 누가 이겼는지 확인

        return answer;
    }

    /**
     * 예외 상황인지 판단하는 메소드
     * @param pobiPage 포비가 뽑은 페이지
     * @param crongPage 크롱이 뽑은 페이지
     * @return 예외 상황이면 true 반환 예외 상황이 아니면 false 반환
     */
    static boolean isException(int[] pobiPage, int[] crongPage){
        // 페이지의 값이 1 차이가 나는지 확인
        if(pobiPage[0] != pobiPage[1] - 1 || crongPage[0] != crongPage[1] - 1){
            return true;
        }

        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 확인
        if(pobiPage[0] % 2 != 1 || pobiPage[1] % 2 != 0 || crongPage[0] % 2 != 1 || crongPage[1] % 2 != 0){
            return true;
        }

        return false;
    }

}