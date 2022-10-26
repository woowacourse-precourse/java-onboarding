package onboarding;

import java.util.List;

class Problem1 {

//      1. 입력받은 페이지의 정보를 필드로 가지는 Player 클래스 작성
//          객체 생성시, 페이지 정보가 담긴 List 를 매개변수로 받아 필드를 초기화 하도록 설계
//          (페이지의 각 자릿수에 index 로 접근하기 위해 List 를 이용하여 String 형태로 leftPage 와 rightPage 를 초기화 함)

//      2. 페이지 정보를 바탕으로, 왼쪽 페이지와 오른쪽 페이지를 기능 요구사항에 따라
//          각 자릿수를 모두 더한 값, 각 자릿수를 모두 곱한 값을 비교해
//          더 큰 값을 구한 뒤
//          그렇게 얻은 왼쪽 페이지와 오른쪽 페이지의 계산 결과값(해당 객체가 로직에 따라 얻을 수 있는 가장 높은 값)을 리턴하는 함수 작성

//      3. 잘못된 값(왼쪽 페이지와 오른쪽 페이지의 숫자가 연속되지 않는 경우)이 주어졌을때
//          기능 요구사항에 따라 예외를 발생시키기 위한 검증 로직을 담은 함수 작성

//      4. solution 함수에서 Player 객체 생성후, 각 객체의 점수를 비교하여 조건에따라 리턴


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        Player playerPobi = new Player(pobi);
        Player playerCrong = new Player(crong);

        int pobiScore = playerPobi.calcScore();
        int crongScore = playerCrong.calcScore();

        try {

            validate(playerPobi);
            validate(playerCrong);

            if(pobiScore > crongScore) {
                answer = 1;
            }else if(pobiScore == crongScore){
                answer = 0;
            }else{
                answer = 2;
            }

        }catch (IllegalArgumentException e){
            answer = -1;
        }

        return answer;
    }

    public static void validate(Player player){

        int leftPage = Integer.parseInt(player.leftPage);
        int rightPage = Integer.parseInt(player.rightPage);

        if(rightPage-leftPage != 1){
            throw new IllegalArgumentException();
        }
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



//      객체가 가진 최고 값을 계산하는 메서드
        public int calcScore() {

            int leftPageResult;
            int rightPageResult;

            for (int i = 0; i < this.leftPage.length(); i++) {

                char c = leftPage.charAt(i);
                leftPageSumResult += Character.getNumericValue(c);
                leftPageMultiplyResult *= Character.getNumericValue(c);
            }
            leftPageResult = Math.max(leftPageSumResult,leftPageMultiplyResult);

            for (int i = 0; i < this.rightPage.length(); i++) {

                char c = rightPage.charAt(i);
                rightPageSumResult += Character.getNumericValue(c);
                rightPageMultiplyResult *= Character.getNumericValue(c);
            }
            rightPageResult = Math.max(rightPageSumResult,rightPageMultiplyResult);

            return  Math.max(leftPageResult,rightPageResult);
        }


    }

}