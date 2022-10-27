package onboarding;

import java.util.List;

public class PageGame implements Rule {

    public boolean isValid(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != 2 && list2.size() != 2)
            return false;

        return isValid(list1.get(0), list1.get(1))
                && isValid(list2.get(0), list2.get(1));
    }

    private boolean isValid(int leftPage, int rightPage) {
        if ((leftPage <= 0) || rightPage > 400)
            return false;

        if (rightPage - leftPage != 1)
            return false;

        if (leftPage % 2 != 1)
            return false;

        if (rightPage % 2 != 0)
            return false;

        return true;
    }

    public int winner(int pobiNum, int crongNum) {
        if (pobiNum == crongNum)
            return Winner.DRAW.getWinner();

        if (pobiNum > crongNum)
            return Winner.POBI.getWinner();

        if (pobiNum < crongNum)
            return Winner.CRONG.getWinner();

        return -1;
    }
}
