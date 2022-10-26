package onboarding;

import java.util.List;

class Problem1 {


    private static boolean pageSequence;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        int pobiFirstNumber = pobi.get(0);
        int pobiSecondNumber = pobi.get(1);

        int crongFirstNumber = pobi.get(0);
        int crongSecondNumber = pobi.get(1);

        if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber){
            pageSequence = false;
            answer = -1;
        }

        int pobiMaxValue = 0;
        int crongMaxValue = 0;

        // 자리수 확인

        answer = Integer.MAX_VALUE;
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