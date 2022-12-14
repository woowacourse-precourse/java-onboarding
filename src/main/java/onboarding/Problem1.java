//1. 책을 펼쳤을때 예외가 있는지 확인
//시작면이나 마지막 면이 나왔는가
//왼쪽페이지에 홀수, 오른쪽페이지에 짝수가 적혀있는가
//두 페이지 수 차이가 1이 나는게 맞는가
//2. 포비의 점수 계산
//3. 크롱의 점수 계산
//4. 승자가 누구인지 구함

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(isValid(pobi) && isValid(crong))) {
            return -1;
        }

        int pobiScore = score(pobi);
        int crongScore = score(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore == crongScore) {
            return 0;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return answer;
    }

    private static boolean isValid(List<Integer> pageList) {
        if (pageList.get(0) < 1 || pageList.get(0) > 400 || pageList.get(1) < 1 || pageList.get(1) > 400) {
            return false;
        }
        if (pageList.get(0)%2 == 0 || pageList.get(1)%2 != 0) {
            return false;
        }
        if ((pageList.get(0) - pageList.get(1)) != -1) {
            return false;
        }
        return true;
    }

    private static int score(List<Integer> pageList) {
        int left = pageList.get(0);
        int right = pageList.get(1);
        int leftPlus = 0;
        int leftMultiply = 1;
        int rightPlus = 0;
        int rightMultiply = 1;
        while (left != 0) {
            int leftTmp = left%10;
            leftPlus += leftTmp;
            leftMultiply *= leftTmp;
            left = left/10;
        }

        while (right != 0) {
            int rightTmp = right%10;
            rightPlus += rightTmp;
            rightMultiply *= rightTmp;
            right = right/10;
        }

        int leftScore = Math.max(leftPlus, leftMultiply);
        int rightScore = Math.max(rightPlus, rightMultiply);

        return Math.max(leftScore, rightScore);
    }
}