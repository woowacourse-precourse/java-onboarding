package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int left = 0;
        int right = 1;

        int answer = Integer.MAX_VALUE;

        //pobi findMaxNum
        calculation(pobi.get(left), pobi.get(right));
        //crng findMaxNum
        calculation(crong.get(left), crong.get(left));

        return answer;
    }

    //find digits
    public static int[] digit(int num)
    {
        int []value = null;
        int i = 0;

        while(num > 0)
        {
            value[i] = num % 10;
            num /= 10;
        }
        return value;
    }

    public static int calculation(int[] num)
    {
        int sum = 0;
        int multiply = 0;
        int max = 0;

        int [] leftDigit;
        int [] rightDigit;

        for (int i = 0; i < num.length; i++)
        {
            sum += num[i];
            multiply *= num[i];
        }

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

}
