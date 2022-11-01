package onboarding;
import java.util.List;
import java.util.ArrayList;

class Problem1 {
//    public static int getMaxOfSumAndMul(ArrayList<Integer> digits) {
//        int sum = 0;
//        int mul = 1;
//        for (int digit: digits){
//            sum += digit;
//            mul *= digit;
//        }
//        return Math.max(sum, mul);
//    }

    public static ArrayList<Integer> intToDigits(int num)
    {
        ArrayList<Integer> Digits = new ArrayList<Integer>();
        int hundreds = num / 100;
        int tens = (num / 10) - (hundreds * 10);
        int units = num % 10;
        if (num < 10){
            Digits.add(units);
        }
        else if (num < 100){
            Digits.add(tens);
            Digits.add(units);
        }
        else{
            Digits.add(hundreds);
            Digits.add(tens);
            Digits.add(units);
        }
        return (Digits);
    }

    public static boolean isProperInput(List<Integer> inputList)
    {
        if (!(inputList.size() == 2))
            return false;
        if (!(inputList.get(0) % 2 == 1 && inputList.get(1) == inputList.get(0) + 1))
            return false;
        if (!(3 <= inputList.get(0) && inputList.get(0) <= 397))
            return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = Integer.MAX_VALUE;
        int crongMax = Integer.MAX_VALUE;
        int num = Integer.MAX_VALUE;
        ArrayList<Integer> leftDigits;
        ArrayList<Integer> rightDigits;

        if (!(isProperInput(pobi) && isProperInput(crong)))
        {
            answer = -1;
            return (answer);
        }
        num = pobi.get(0);
        leftDigits = intToDigits(num);
        rightDigits = intToDigits(num + 1);
        pobiMax = Math.max(getMaxOfSumAndMul(leftDigits), getMaxOfSumAndMul(rightDigits));

        num = crong.get(0);
        leftDigits = intToDigits(num);
        rightDigits = intToDigits(num + 1);
        crongMax = Math.max(getMaxOfSumAndMul(leftDigits), getMaxOfSumAndMul(rightDigits));

        if (pobiMax > crongMax)
            answer = 1;
        else if (pobiMax < crongMax)
            answer = 2;
        else
            answer = 0;
        return answer;
    }
}