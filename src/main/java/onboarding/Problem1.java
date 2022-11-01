package onboarding;

import java.util.List;

class Problem1 {

    //페이지 계산 중 큰 숫자 저장할 변수
    private static int pobinum; //포비 최종 점수
    private static int crongnum; //크롱 최종 점수
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //점수 초기화
        pobinum = 0;
        crongnum = 0;

        //페이지가 제대로 들어오지 않을 경우(예외 상황) -1 리턴하는 기능
        if( pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1) ) {
            return -1;
        }


        //answer 선언
        int answer = 0;

        return answer;
    }



}