package onboarding;

import java.util.List;

class Pages implements Comparable<Pages>
{
    private static final int DIVISION_VALUE = 10;
    private static final int INPUT_SIZE = 2;
    private static final int LEFT_BOUND= 0;
    private static final int RIGHT_BOUND = 401;

    private List<Integer> pages;

    public Pages(List<Integer> pages)
    {
        this.pages = pages;
        if(!checkValidation())
        {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    private Integer getLeftPage(List<Integer> player)
    {
        return player.get(0);
    }
    private Integer getRightPage(List<Integer> player)
    {
        return player.get(1);
    }
    private boolean checkValidation()
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

    private int getValueByPage(Integer page)
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

    public int getValue()
    {
        int leftPage = getLeftPage(pages);
        int rightPage = getRightPage(pages);

        return Math.max(getValueByPage(leftPage),getValueByPage(rightPage));
    }

    private static final int WIN_VALUE = 1;
    private static final int DEFEAT_VALUE = 2;
    private static final int DRAW_VALUE = 0;
    @Override
    public int compareTo(Pages o) {
        int thisValue = getValue();
        int oValue = o.getValue();

        if(thisValue > oValue) return WIN_VALUE;
        else if(thisValue < oValue) return DEFEAT_VALUE;
        else return DRAW_VALUE;

    }
}

public class Problem1 {

    private static final int EXCEPTION_VALUE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Pages pobiPage = new Pages(pobi);
            Pages crongPage = new Pages(crong);

            return pobiPage.compareTo(crongPage);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_VALUE;
        }


    }

}