package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //1.왼쪽 & 오른쪽 페이지 취득
        int pLeftPage = pobi.get(0); //97
        int pRightPage = pobi.get(1); //98

        int cLeftPage = crong.get(0); //197
        int cRightPage = crong.get(1); //198

        //2.입력값 검증
        if(pRightPage - pLeftPage != 1 || cRightPage - cLeftPage != 1)
            return -1;



        //
        return answer;
    }


}