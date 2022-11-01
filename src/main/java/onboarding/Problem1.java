package onboarding;

import java.util.List;

class Problem1 {

    static private final int EXCEPTION_ANSWER = -1;
    static private final int POBI_WIN = 1;
    static private final int CRONG_WIN = 2;
    static private final int DRAW = 0;

    static private final int FIRST_PAGE = 1;
    static private final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if(isException(pobiLeft, pobiRight) || isException(crongLeft, crongRight)) {
            return EXCEPTION_ANSWER;
        }

        int pobiScore = getScore(pobiLeft, pobiRight);
        int crongScore = getScore(crongLeft, crongRight);

        answer = getAnswer(pobiScore, crongScore);
        return answer;
    }

    public static boolean isException(int leftPage, int rightPage) {
        if(leftPage <= FIRST_PAGE || rightPage >= LAST_PAGE)
            return true;
        if(leftPage >= rightPage)
            return true;
        if((rightPage - leftPage) != 1)
            return true;

        return false;
    }

    public static int getScore(int leftPage, int rightPage) {
        int leftScore = makeBiggerNum(leftPage);
        int rightScore = makeBiggerNum(rightPage);

        return Math.max(leftScore, rightScore);
    }

    public static int makeBiggerNum(int num) {
        int sum = 0, mul = 1;

        char[] numArr = String.valueOf(num).toCharArray();
        for(int i = 0; i < numArr.length; i++) {
            sum += numArr[i];
            mul *= numArr[i];
        }

        return Math.max(sum, mul);
    }

    public static int getAnswer(int pobiScore, int crongScore) {
        if(pobiScore > crongScore)
            return POBI_WIN;
        else if(crongScore < pobiScore)
            return CRONG_WIN;
        else
            return DRAW;
    }
}