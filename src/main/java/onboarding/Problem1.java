package onboarding;

import java.util.List;
/*
0. 예외 처리
    - 왼쪽 페이지가 홀수인지, 오른쪽 페이지가 짝수인지 확인
    - 왼쪽은 1~399 숫자인지, 오른쪽은 2 ~ 400 숫자인지 확인
    - 왼쪽 페이지와 오른쪽 페이지가 연속되는 숫자인지 확인
    - 페이지가 2개인지 확인
1. 가장 큰 점수를 구하는 함수
2. 비교하는 함수
*/
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isValidPage(pobi) || !isValidPage(crong))
            return (-1);
        int pobiScore = findMaxScore(pobi);
        int crongScore = findMaxScore(crong);

        return computeScore(pobiScore, crongScore);
    }
    private static boolean isValidPage(List<Integer> page)
    {
        int leftPage = page.get(0);
        int rightPage = page.get(1);

        if (page.size() != 2)
            return false;
        if (leftPage < 1 || leftPage > 399
                || rightPage < 2 || rightPage > 400)
            return false;
        if (leftPage % 2 == 0 || rightPage % 2 == 1)
            return false;
        if ((leftPage + 1) != rightPage)
            return false;
        return true;
    }

    private static int findMaxScore(List<Integer> page)
    {
        int addLeftScore = 0;
        int multiLeftScore = 1;
        int left_number = page.get(0);

        while (left_number > 0) {
            addLeftScore += (left_number % 10);
            multiLeftScore *= (left_number % 10);
            left_number /= 10;
        }
        int left_max = Math.max(addLeftScore, multiLeftScore);
        int addRightScore = 0;
        int multiRightScore = 1;
        int right_number = page.get(1);

        while (right_number > 0) {
            addRightScore += (right_number % 10);
            multiRightScore *= (right_number % 10);
            right_number /= 10;
        }
        int right_max = Math.max(addRightScore, multiRightScore);
        return (Math.max(left_max, right_max));
    }

    private static int computeScore(int povyNum, int crongNum) {
        int returnValue = 0;
        if (povyNum > crongNum)
            returnValue = 1;
        else if (povyNum < crongNum)
            returnValue = 2;
        return (returnValue);
    }
}