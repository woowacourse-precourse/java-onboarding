package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxPobi, maxCrong;

        maxPobi = GetMaxPageValue(pobi);
        maxCrong = GetMaxPageValue(crong);

        //예외 검사
        if(CheckException(pobi) || CheckException(crong)){
            return -1;
        }
        if(maxPobi > maxCrong){
            answer = 1;
        } else if(maxPobi < maxCrong){
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    /**
      * 왼쪽 페이지와 오른쪽 페이지의 자릿수 합과 곱을 계산
      * @param pages 페이지 쪽수가 적힌 리스트
      * @return 페이지 자릿수 합과 곱 중에서 큰 수를 반환
     */
    public static int GetMaxPageValue(List<Integer> pages){
        int leftPage = pages.get(0); // 왼쪽 페이지 저장
        int rightPage = pages.get(1); // 오른쪽 페이지 저장

        int maxLeftPage = CalculateDecimalPoint(leftPage);
        int maxRightPage = CalculateDecimalPoint(rightPage);

        return CompareNumbers(maxLeftPage, maxRightPage);
    }

    /** 페이지의 자릿수 합과 곱을 계산하고 크기를 비교.
     * @param pageNumber 페이지 쪽 수
     * @return 자릿수 합과 곱 중 더 큰
     */
    public static int CalculateDecimalPoint(int pageNumber){
        int pageSum = 0;
        int pageMultiply = 1;

        while(pageNumber > 1){
            pageSum += pageNumber % 10;
            pageMultiply *= pageNumber % 10;
            pageNumber /= 10;
        }
        return CompareNumbers(pageSum, pageMultiply);
    }

    /** 두개의 수를 비교.
     * @param number1 비교 되는 수 1
     * @param number2 비교 되는 수 2
     * @return 둘 중에 더 큰 수
     */
    public static int CompareNumbers(int number1, int number2){
        if(number1 > number2){
            return number1;
        } else {
            return number2;
        }
    }

    /** 예외사항 체크 메소드.
     * @param Player 게임의 참여하는 사람의 페이지 리스트
     * @return 예외사항에 걸릴 경우 true, 아닐 경우 false
     */
    public static boolean CheckException(List<Integer> Player){
        int leftPage = Player.get(0);
        int rightPage = Player.get(1);

        //제대로 된 페이지가 아닐 경우
        if(rightPage - leftPage != 1) {
            return true;
        }
        //시작면이나 마지막 면이 나오도록 책을 펼친 경우
        if(leftPage <= 1 || leftPage >= 400 || rightPage <= 1 || rightPage>=400 ) {
            return true;
        }
        return false;
    }
}