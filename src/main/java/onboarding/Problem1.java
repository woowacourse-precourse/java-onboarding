/*
 * 클래스명: Problem1
 *
 * 시작 날짜: 2022-10-27
 */

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        MaxPoint maxPoint = new MaxPoint();
        
        int pobiMaxPoint = maxPoint.maxPoint(pobi);
        int crongMaxPoint = maxPoint.maxPoint(crong);
        int answer;

        if (pobiMaxPoint==-1 || crongMaxPoint==-1){
            answer = -1;
        } else if (pobiMaxPoint>crongMaxPoint){
            answer = 1;
        } else if (pobiMaxPoint<crongMaxPoint){
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}

class MaxPoint {
    public int maxPoint(List<Integer> player) {
        String leftPage = String.valueOf(player.get(0));
        String rightPage = String.valueOf(player.get(1));
        int myPoint;

        if (Math.abs(Integer.parseInt(leftPage) - Integer.parseInt(rightPage)) == 1) {
            int leftPlus = 0;
            int leftTimes = 1;
            int rightPlus = 0;
            int rightTimes = 1;

            for (int i = 0; i < leftPage.length(); i++) {
                //nSystem.out.println("Before leftPlus: "+leftPlus);
                leftPlus += (int) leftPage.charAt(i) - '0';
                leftTimes *= ((int) leftPage.charAt(i) - '0');
            }

            for (int i = 0; i < rightPage.length(); i++) {
                rightPlus += (int) rightPage.charAt(i) - '0';
                rightTimes *= ((int) rightPage.charAt(i) - '0');
            }

            myPoint = Math.max(Math.max(leftPlus, leftTimes), Math.max(rightPlus, rightTimes));

        } else {
            myPoint = -1;
        }

        return myPoint;
    }
}