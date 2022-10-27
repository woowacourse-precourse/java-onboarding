package onboarding;

import java.util.List;

class Problem1 {
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION = -1;

    public static int addDigits(int number){
        int sum = 0;
        while(number > 0){
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    public static int multiplyDigits(int number){
        int product = 1;
        while(number > 0){
            int digit = number % 10;
            product *= digit;
            number /= 10;
        }
        return product;
    }

    public static int getMax(List<Integer> player){
        int leftSum = addDigits(player.get(0));
        int rightSum = addDigits(player.get(1));
        int leftProduct = multiplyDigits(player.get(0));
        int rightProduct = multiplyDigits(player.get(1));

        int leftMax = compareNumbers(leftSum, leftProduct);
        int rightMax = compareNumbers(rightSum, rightProduct);

        int result = compareNumbers(leftMax, rightMax);
        return result;
    }

    public static int compareNumbers(int number1, int number2){
        int result = 0;
        if(number1 > number2){
            result = number1;
        }
        if(number2 >= number1){
            result = number2;
        }
        return result;
    }

    public static boolean checkValidity(List<Integer> player){
        boolean result = true;
        int number1 = player.get(0);
        int number2 = player.get(1);
        if(player.size() > 2){
            result = false;
        }
        if(number1 < MIN_PAGE || number1 > MAX_PAGE){
            result = false;
        }
        if(number2 < MIN_PAGE || number2 > MAX_PAGE){
            result = false;
        }
        if(number2 - number1 != 1){
            result = false;
        }
        if(number1 % 2 == 0 && number2 % 2 == 1){
            result = false;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean isValidInput = checkValidity(pobi) && checkValidity(crong);
        if(isValidInput){
            int pobiTotalMax = getMax(pobi);
            int crongTotalMax = getMax(crong);
            if(pobiTotalMax > crongTotalMax){
                answer = POBI_WIN;
            }
            if(pobiTotalMax < crongTotalMax){
                answer = CRONG_WIN;
            }
            if(pobiTotalMax == crongTotalMax){
                answer = TIE;
            }
        }

        if(!isValidInput){
            answer = EXCEPTION;
        }
        return answer;
    }
}