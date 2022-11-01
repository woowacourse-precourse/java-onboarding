package onboarding.solution1;

import java.util.List;

public class IsException {
    private static int numOfIndex(List<Integer> page){
        int num = page.size();
        if (num != 2)
            return -1;
        return 0;
    }

    private static int oddRange(int page){
        if (page < 0 || page > 399)
            return -1;
        return 0;
    }

    private static int odd(int page){
        if (page % 2 == 0)
            return -1;
        return 0;
    }

    private static int nextPage(int oddPage, int evenPage){
        if (oddPage + 1 != evenPage)
            return -1;
        return 0;
    }
    public static int isException(List<Integer> page){
        if (numOfIndex(page) == -1)
            return -1;
        if (oddRange(page.get(0)) == -1)
            return -1;
        if (odd(page.get(0)) == -1)
            return -1;
        if (nextPage(page.get(0), page.get(1)) == -1)
            return -1;
        return 0;
    }
}
