package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);
        int pobiMax;
        int crongMax;

        if(checkException(pobiLeftPage, pobiRightPage) || checkException(crongLeftPage, crongRightPage))
            return -1;

        pobiMax = getMaxScore(pobiLeftPage, pobiRightPage);
        crongMax = getMaxScore(crongLeftPage, crongRightPage);

        return getCompareScore(pobiMax, crongMax);
    }

    public static boolean checkException(int leftPage, int rightPage){
        if(leftPage+1 != rightPage
                ||(leftPage < 3) ||(rightPage < 3)
                ||(leftPage > 398) ||(rightPage > 398)
                ||((leftPage % 2) == 0) ||((rightPage % 2) == 1))
            return true;

        return false;
    }

    public static int getMaxScore(int leftPage, int rightPage){
        return Math.max(Math.max(plusBookNum(leftPage), multiBookNum(leftPage)),
                Math.max(plusBookNum(rightPage), multiBookNum(rightPage)));
    }

    public static int plusBookNum(int num){
        int sum=0;
        while(num > 0) {
            sum+= num %10;
            num /= 10;
        }
        return sum;
    }

    public static int multiBookNum(int num){
        int sum=1;
        while(num > 0) {
            sum*= num %10;
            num /= 10;
        }
        return sum;
    }

    public static int getCompareScore(int pobiMax, int crongMax){
        if(pobiMax > crongMax)
            return 1;

        if(pobiMax < crongMax)
            return 2;

        // pobiMax == corongMax
        return 0;
    }
}