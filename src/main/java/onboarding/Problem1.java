package onboarding;

import java.util.List;

public class Problem1 {
    private static final int POBI_WIN_VALUE = 1;
    private static final int CRONG_WIN_VALUE = 2;
    private static final int DRAW_VALUE = 0;
    private static final int EXCEPTION_VALUE = -1;
    private static final int INPUT_SIZE = 2;
    private static final int LEFT_BOUND= 0;
    private static final int RIGHT_BOUND = 401;
    private static final int DIVISION_VALUE = 10;

    private static boolean checkValidation(List<Integer> pages)
    {
        if(pages.size() != INPUT_SIZE)
        {
            return false;
        }

        Integer leftPageNumber = getLeftPage(pages);
        Integer rightPageNumber = getRightPage(pages);

        return leftPageNumber == (rightPageNumber - 1)
                && leftPageNumber > LEFT_BOUND
                && rightPageNumber < RIGHT_BOUND;
    }

    private static Integer getLeftPage(List<Integer> inputList)
    {
        return inputList.get(0);
    }

    private static Integer getRightPage(List<Integer> inputList)
    {
        return inputList.get(1);
    }
    private static int getValueByPage(Integer page)
    {
        int nowDigit = page % DIVISION_VALUE;
        int nowValue = page / DIVISION_VALUE;

        int sumValue = nowDigit;
        int multiplicationValue = nowDigit;

        while(nowValue != 0)
        {
            nowDigit = nowValue % DIVISION_VALUE;

            sumValue += nowDigit;
            multiplicationValue *= nowDigit;

            nowValue /= DIVISION_VALUE;
        }

        return Math.max(multiplicationValue, sumValue);
    }

    public static int getGameValue(List<Integer> pages)
    {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);

        return Math.max(getValueByPage(leftPage),getValueByPage(rightPage));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong)
    {
        if(checkValidation(pobi) && checkValidation(crong))
        {
            int pobiGameValue = getGameValue(pobi);
            int crongGameValue = getGameValue(crong);
            int returnValue;

            if(pobiGameValue > crongGameValue)
            {
                returnValue = POBI_WIN_VALUE;
            }
            else if(pobiGameValue < crongGameValue)
            {
                returnValue = CRONG_WIN_VALUE;
            }
            else
            {
                returnValue = DRAW_VALUE;
            }

            return returnValue;
        }

        return EXCEPTION_VALUE;
    }



}