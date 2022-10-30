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

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}