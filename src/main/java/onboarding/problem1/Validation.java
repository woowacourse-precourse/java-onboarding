package onboarding.problem1;

import java.util.List;


public class Validation {
    private static final int LEFT_PAGE_LIMIT = 1;
    private static final int RIGHT_PAGE_LIMIT = 400;
    private static final int PAGE_SIZE = 2;
    private static final int ONE_PAGE = 1;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static boolean check(List<Integer> user) {
        int pageSize = user.size();
        if (pageSize != PAGE_SIZE) {
            return false;
        }
        int leftPage = user.get(LEFT_PAGE);
        int rightPage = user.get(RIGHT_PAGE);
        if (leftPage <= LEFT_PAGE_LIMIT || rightPage >= RIGHT_PAGE_LIMIT) {
            return false;
        } else if (rightPage != leftPage + ONE_PAGE) {
            return false;
        } else if (leftPage % PAGE_SIZE != 1) {
            return false;
        }
        return true;
    }
}
