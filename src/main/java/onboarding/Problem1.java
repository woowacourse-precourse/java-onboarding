package onboarding;

import java.util.List;

class Problem1 {

    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeft = pobi.get(0); int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0); int crongRight = crong.get(1);

        if(isException(pobiLeft, pobiRight) || isException(crongLeft, crongRight)) {
            answer = -1;
        } else {
            int pobiScore = getScore(pobiLeft, pobiRight);
            int crongScore = getScore(crongLeft, crongRight);
            answer = getAnswer(pobiScore, crongScore);
        }

        return answer;
    }

    public static boolean isException(int leftPage, int rightPage) {
        if(leftPage == FIRST_PAGE || leftPage == LAST_PAGE)
            return true;
        if((rightPage - leftPage) != 1)
            return true;

        return false;
    }

    public static int getScore(int left, int right) {
        int leftScore = makeBiggerNum(left);
        int rightScore = makeBiggerNum(right);

        return Math.max(leftScore, rightScore);
    }

    public static int makeBiggerNum(int num) {
        int sum = 0, mul = 1, max = Integer.MIN_VALUE;

        char[] numArr = String.valueOf(num).toCharArray();
        for(int i = 0; i < numArr.length; i++) {
            sum += (int)numArr[i];
            mul *= (int)numArr[i];
        }

        return Math.max(sum, mul);
    }

    public static int getAnswer(int pobiScore, int crongScore) {
        if(pobiScore > crongScore)
            return 1;
        else if(crongScore < pobiScore)
            return 2;
        else
            return 0;
    }
}