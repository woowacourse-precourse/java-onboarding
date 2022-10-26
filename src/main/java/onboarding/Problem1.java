package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;
        int pobiMaxValue = 0;
        int crongMaxValue = 0;

        int pobiFirstNumber = pobi.get(0);
        int pobiSecondNumber = pobi.get(1);

        int crongFirstNumber = crong.get(0);
        int crongSecondNumber = crong.get(1);

        if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber){
            answer = -1;
        } else {

            List pobiMaxNumbersList = new ArrayList();
            List crongMaxNumbersList = new ArrayList();

            pobiMaxNumbersList.add(getMaxNumber(pobiFirstNumber));
            pobiMaxNumbersList.add(getMaxNumber(pobiSecondNumber));
            crongMaxNumbersList.add(getMaxNumber(crongFirstNumber));
            crongMaxNumbersList.add(getMaxNumber(crongSecondNumber));

            pobiMaxValue = (int) Collections.max(pobiMaxNumbersList);
            crongMaxValue = (int) Collections.max(crongMaxNumbersList);

            if (pobiMaxValue == crongMaxValue) {
                answer = 0;
            } else if (pobiMaxValue > crongMaxValue) {
                answer = 1;
            } else if (pobiMaxValue < crongMaxValue) {
                answer = 2;
            }
        }

        return answer;
    }

    private static int numberLength(int number){
        int length = (int)(Math.log10(number)+1);
        return length;
    }

    private static int getMaxNumber(int number){
        int MaxValue = 0;

        if (numberLength(number) == 3){
            int FirstNumberFirstDigit = number / 100;
            int FirstNumberSecondDigit = (number % 100) / 10;
            int FirstNumberThirdDigit = (number % 100) % 10;

            int Addition = getAddition(FirstNumberFirstDigit, FirstNumberSecondDigit, FirstNumberThirdDigit);
            int Multiplication = getMultiplication(FirstNumberFirstDigit, FirstNumberSecondDigit, FirstNumberThirdDigit);
            if (Addition > Multiplication){
                MaxValue = Addition;
            } else {
                MaxValue = Multiplication;
            }


        } else if (numberLength(number) == 2){
            int FirstNumberFirstDigit = (number % 100) / 10;
            int FirstNumberSecondDigit = (number % 100) % 10;

            int Addition = getAddition(FirstNumberFirstDigit, FirstNumberSecondDigit);
            int Multiplication = getMultiplication(FirstNumberFirstDigit, FirstNumberSecondDigit);
            if (Addition > Multiplication){
                MaxValue = Addition;
            } else {
                MaxValue = Multiplication;
            }
        } else {
            MaxValue = number;
        }

        return MaxValue;
    }

    public static int getAddition(int... numbers){
        int sum=0;
        for (int i =0; i < numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static int getMultiplication(int ... numbers){
        int multiply = 1;
        for (int i = 0; i < numbers.length; i++){
            multiply = multiply * numbers[i];
        }
        return multiply;
    }
}