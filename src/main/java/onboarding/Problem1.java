package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    /**
     * 좌,우측 페이지가 올바른 페이지 인지 확인하는 함수
     *
     * @param pages 좌, 우 페이지 번호가 적힌 리스트
     * @return 유효한 페이지인지 검사값 (true/false)
     */
    public static boolean checkPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage + 1 != rightPage) { // 왼쪽 페이지와 오른쪽 페이지 차가 1이 아닌 경우
            return false;
        }
        if(leftPage%2 !=1 || rightPage%2!=0){ // 왼쪽에 홀수 페이지, 오른쪽에 짝수 페이지가 아닌 경우
            return false;
        }
        if (leftPage==1 || rightPage == 400){ // 시작 페이지와 끝 페이지 인 경우
            return false;
        }
        return true;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(checkPage(pobi) && checkPage(crong))) {
            return -1;
        }

        return answer;
    }
}

