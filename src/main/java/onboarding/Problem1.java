package onboarding;

import java.util.List;

class Problem1 {

//     1. 입력받은 페이지의 정보를 필드로 가지는 Player 클래스 작성
//          객체 생성시, 페이지 정보가 담긴 List 를 매개변수로 받아 필드를 초기화 하도록 설계
//          (페이지의 각 자릿수에 index 로 접근하기 위해 List 를 이용하여 String 형태로 leftPage 와 rightPage 를 초기화 함)


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static class Player {

        String leftPage;
        String rightPage;

        int leftPageSumResult = 0;
        int leftPageMultiplyResult = 1;

        int rightPageSumResult = 0;
        int rightPageMultiplyResult = 1;

        Player(List<Integer> list) {
            this.leftPage = list.get(0) + "";
            this.rightPage = list.get(list.size() - 1) + "";
        }
    }

}