package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int leftPagePobi = pobi.get(0);
        int rightPagePobi = pobi.get(1);
        int leftPageCrong = crong.get(0);
        int rightPageCrong = crong.get(1);

        /*예외사항 발생시 처리*/
        if (validatePageNumber(leftPagePobi, rightPagePobi) || validatePageNumber(leftPageCrong, rightPageCrong)) {
            answer = -1;
            return answer;
        }

        /*포비와 크롱의 왼쪽, 오른쪽 페이지 중에 가장 큰 값 구하기*/
        int scorePobi = Math.max(calculateMaxPage(leftPagePobi), calculateMaxPage(rightPagePobi));
        int scoreCrong = Math.max(calculateMaxPage(leftPageCrong), calculateMaxPage(rightPageCrong));

        /*포비와 크롱 대결 승패 결정*/


        return answer;
    }

    public static boolean validatePageNumber(int leftPage, int rightPage) {
        if (leftPage % 2 != 1 || rightPage % 2 != 0 || rightPage - leftPage != 1) {
            return true;
        }
        return false;
    }

    public static int calculateMaxPage(int pageNumber) {
        if (pageNumber >= 100) {
            int hundred = pageNumber / 100;
            int ten = pageNumber / 10 % 10;
            int one = pageNumber % 10;

            return Math.max(hundred + ten + one, hundred * ten * one);
        } else if (pageNumber >= 10) {
            int ten = pageNumber / 10 % 10;
            int one = pageNumber % 10;

            return Math.max(ten + one, ten * one);
        } else {
            return pageNumber % 10;
        }
    }

}