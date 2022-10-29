package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int addPages(int leftPage, int rightPage) {

        int leftSum = 0, rightSum = 0;

        while (leftPage > 0) {
            leftSum += leftPage % 10;
            leftPage /= 10;
        }
        while (rightPage > 0) {
            rightSum += rightPage % 10;
            rightPage /= 10;
        }

        if (leftSum >= rightSum)
            return leftSum;
        return rightSum;
    }

    public static int mulPages(int leftPage, int rightPage) {

        int leftMul = 1, rightMul = 1;

        while (leftPage > 0) {
            leftMul *= leftPage % 10;
            leftPage /= 10;
        }
        while (rightPage > 0) {
            rightMul *= rightPage % 10;
            rightPage /= 10;
        }

        if (leftMul >= rightMul)
            return leftMul;
        return rightMul;
    }

    public static int compareBoth(List<Integer> pages) {

        int leftPage = pages.get(0), rightPage = pages.get(1);

        int addVal = addPages(leftPage, rightPage);
        int mulVal = mulPages(leftPage, rightPage);

        if (addVal >= mulVal)
            return addVal;
        return mulVal;
    }
}