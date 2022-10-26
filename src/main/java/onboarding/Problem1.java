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

    //자리수 구하고 배열에 저장
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

        max = Math.max(sum, exceptionCheck(multiply));

        return max;
    }

    //점수 구하기 : 연산한 값의 max값을 찾기
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

    //점수 비교 후 결과 반환
    public static int compareNum(int pobiNum, int crongNum)
    {
        if (pobiNum == errorNum || crongNum == errorNum)
            return -1;
        if (pobiNum == crongNum)
            return 0;
        else if (pobiNum > crongNum)
            return 1;
        else if (pobiNum < crongNum)
            return 2;

        return -1;
    }

    //연산한 값에 0이 있을 경우
    public static int exceptionCheck(int multiplyNum)
    {
        if (multiplyNum == 0)
            return errorNum;
        return multiplyNum;
    }
}
