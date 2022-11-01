package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(invalidPages(pobi) || invalidPages(crong)) return -1;

        return getResultOfPageGame(pobi, crong);
    }

    public static boolean invalidPages(List<Integer> pages) {

        int leftPage = pages.get(0), rightPage = pages.get(1);

        if (leftPage < 0 || leftPage > 400) return true;
        if (rightPage < 0 || rightPage > 400) return true;

        if (leftPage+1 != rightPage) return true;

        if (leftPage % 2 == 0) return true;

        if (leftPage == 1 || rightPage == 400) return true;

        return false;
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

    public static int getResultOfPageGame(List<Integer> pobi, List<Integer> crong) {

        int pobiMaxVal = compareBoth(pobi);
        int crongMaxVal = compareBoth(crong);

        if (pobiMaxVal > crongMaxVal) return 1;
        if (pobiMaxVal == crongMaxVal) return 0;
        if (pobiMaxVal < crongMaxVal) return 2;

        return -1;
    }
}