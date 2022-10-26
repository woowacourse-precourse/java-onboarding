package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int errorNum = 250;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int left = 0;
        int right = 1;
        int answer = Integer.MAX_VALUE;

        answer = compareNum(findMaxNumber(pobi.get(left), pobi.get(right)), findMaxNumber(crong.get(left), crong.get(left)));

        return answer;
    }

    //find digits
    public static int[] digit(int num)
    {
        int [] valueArray;
        ArrayList<Integer> valueList = new ArrayList<>();

        while(num > 0)
        {
            valueList.add(num % 10);
            num /= 10;
        }

        valueArray = new int[valueList.size()];
        for (int i = 0; i < valueArray.length; i++)
            valueArray[i] = valueList.get(i);
        return valueArray;
    }

    public static int calculation(int[] num)
    {
        int sum = 0;
        int multiply = 0;
        int max = 0;

        for (int i = 0; i < num.length; i++)
        {
            sum += num[i];
            multiply *= num[i];
        }

        exceptionCheck(multiply);
        max = Math.max(sum, multiply);

        return max;
    }

    public static int findMaxNumber(int leftNum, int rightNum)
    {
        int [] leftDigit;
        int [] rightDigit;

        int max = 0;
        leftDigit = digit(leftNum);
        rightDigit = digit(rightNum);

        max = Math.max(calculation(leftDigit), calculation(rightDigit));

        return max;
    }

    //compare number
    public static int compareNum(int pobiNum, int crongNum)
    {
        if (pobiNum == crongNum)
            return 0;
        else if (pobiNum > crongNum)
            return 1;
        else if (pobiNum < crongNum)
            return 2;

        return -1;
    }

    public static int exceptionCheck(int multiplyNum)
    {
        if (multiplyNum == 0)
            return errorNum;
        return multiplyNum;
    }
}
