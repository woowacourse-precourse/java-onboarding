/*
 * 클래스명: Problem1
 *
 * 시작 날짜: 2022-10-27
 */

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        IsValidPage isValidPage = new IsValidPage();
        if(! isValidPage.isValidPage(pobi, crong)){
            return -1;
        }

        MaxPoint maxPoint = new MaxPoint();

        int pobiMaxPoint = maxPoint.maxPoint(pobi);
        int crongMaxPoint = maxPoint.maxPoint(crong);

        if (pobiMaxPoint>crongMaxPoint){
            return 1;
        }
        if (pobiMaxPoint<crongMaxPoint){
            return 2;
        }
        return 0; // 비겼다면
    }
}

class MaxPoint {
    public int maxPoint(List<Integer> player) {
        String leftPage = String.valueOf(player.get(0));
        String rightPage = String.valueOf(player.get(1));

        int myPoint;
        int leftPlus = 0;
        int leftTimes = 1;
        int rightPlus = 0;
        int rightTimes = 1;

        for (int i = 0; i < leftPage.length(); i++) {
            leftPlus += (int) leftPage.charAt(i) - '0';
            leftTimes *= ((int) leftPage.charAt(i) - '0');
        }

        for (int i = 0; i < rightPage.length(); i++) {
            rightPlus += (int) rightPage.charAt(i) - '0';
            rightTimes *= ((int) rightPage.charAt(i) - '0');
        }

        myPoint = Math.max(Math.max(leftPlus, leftTimes), Math.max(rightPlus, rightTimes));
        return myPoint;
    }
}

class IsValidPage {
    public boolean isValidPage(List<Integer> player1, List<Integer> player2) {
        //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인
        int leftPage1 = player1.get(0);
        int leftPage2 = player2.get(0);
        int rightPage1 = player1.get(1);
        int rightPage2 = player2.get(1);

        if(leftPage1 % 2 == 0 || leftPage2 % 2 == 0) {
            return false;
        }
        if(rightPage1 % 2 != 0 || rightPage2 % 2 != 0) {
            return false;
        }
        if(rightPage1 - leftPage1 != 1) {
            return false;
        }
        if(rightPage2 - leftPage2 != 1) {
            return false;
        }
        if(player1.size() != 2 || player2.size() != 2) {
            return false;
        }
        return true;
    }
}