package onboarding.problem1;

import java.util.List;

public class Problem1 {
    private static final int START = 1;
    private static final int END = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = new Page(pobi.get(0), pobi.get(1));
        Page crongPage = new Page(crong.get(0), crong.get(1));

        int answer = Integer.MAX_VALUE;

        if (validate(pobiPage) & validate(crongPage)) {
            answer = -1;
        }



        return answer;
    }

    public static boolean validate(Page page){
        return page.isValidLeft(page.getLeft()) & page.isValidRight(page.getRight()) & page.isBetween(START, END );
    }
}