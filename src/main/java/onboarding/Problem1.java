package onboarding;

import java.util.List;

class UserForPro1 {
    private static final int LIST_LENGTH = 2;
    private final int max;

    public UserForPro1(List<Integer> user) {
        int res = -1;
        if (!validateUser(user)) {
            PageForPro1 maxPage = new PageForPro1(user.get(0), user.get(1));
            res = maxPage.getMax();
        }
        this.max = res;
    }

    private boolean validateUser(List<Integer> user) {
        return user.size() != LIST_LENGTH;
    }

    public int getMax() {
        return max;
    }
}

class PageForPro1 {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    private final int max;

    public PageForPro1(int left, int right) {
        int res = -1;
        if (!validatePage(left, right)) {
            CalculateForPro1 calClass = new CalculateForPro1(left, right);
            res = calClass.compareTwo();
        }
        this.max = res;
    }

    private boolean validatePage(int left, int right) {
        return validatePage1r400(left) || validatePage1r400(right) || validateTwoPages(left, right);
    }

    private boolean validatePage1r400(int page) {
        return page <= START_PAGE || page >= END_PAGE;
    }

    private boolean validateTwoPages(int left, int right) {
        return inSerialNum(left, right) || evenOdd(left, right);
    }

    private boolean inSerialNum(int left, int right) {
        return left + 1 != right;
    }

    public boolean evenOdd(int left, int right) {
        return left % 2 == 0 || right % 2 == 1;
    }

    public int getMax() {
        return max;
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}