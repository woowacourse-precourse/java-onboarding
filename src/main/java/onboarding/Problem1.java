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

        // 포비의 계산결과 넣음

        // 크롱의 계산결과 넣음

        // 누가 이겼는지 확인

        return answer;
    }


}