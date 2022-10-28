package onboarding.solution1;

import java.util.List;

public class IsException {
    private static int numOfIndex(List<Integer> page){
        int num = page.size();
        if (num != 2)
            return -1;
        return 0;
    }

    private static int range(int page){
        if (page < 0 || page > 399)
            return -1;
        return 0;
    }

    private static int odd(int page){
        if (page % 2 == 0)
            return -1;
        return 0;
    }

    public static int isException(List<Integer> page){
        if (numOfIndex(page) == -1)
            return -1;
        if (range(page.get(0)) == -1)
            return -1;
        if (odd(page.get(0)) == -1)
            return -1;
        if (page.get(0) + 1 != page.get(1))
            return -1;
        return 0;
    }
}
