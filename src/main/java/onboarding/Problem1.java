package onboarding;

import java.util.List;

class Problem1 {
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION = -1;
    private static final int INTERVAL = 1;

    public static int addDigits(int pageNumber){
        int sum = 0;
        while(pageNumber > 0){
            int digit = pageNumber % 10;
            sum += digit;
            pageNumber /= 10;
        }
        return sum;
    }

    public static int multiplyDigits(int pageNumber){
        int product = 1;
        while(pageNumber > 0){
            int digit = pageNumber % 10;
            product *= digit;
            pageNumber /= 10;
        }
        return product;
    }

    public static int getMax(List<Integer> player){
        int leftSum = addDigits(player.get(0));
        int rightSum = addDigits(player.get(1));
        int leftProduct = multiplyDigits(player.get(0));
        int rightProduct = multiplyDigits(player.get(1));

        int leftMax = comparePageNumbers(leftSum, leftProduct);
        int rightMax = comparePageNumbers(rightSum, rightProduct);

        int result = comparePageNumbers(leftMax, rightMax);
        return result;
    }

    public static int comparePageNumbers(int leftPageNumber, int rightPageNumber){
        int result = 0;
        if(leftPageNumber > rightPageNumber){
            result = leftPageNumber;
        }
        if(rightPageNumber >= leftPageNumber){
            result = rightPageNumber;
        }
        return result;
    }



    public static boolean checkValidity(List<Integer> player){
        boolean result = true;
        int leftPageNumber;
        int rightPageNumber;

        if(!checkListSize(player)){
            result = false;
            return result;
        }

        leftPageNumber = player.get(0);
        rightPageNumber = player.get(1);

        if(!checkPageNumberRange(leftPageNumber)){
            result = false;
        }
        if(!checkPageNumberRange(rightPageNumber)){
            result = false;
        }
        if(!checkInterval(leftPageNumber, rightPageNumber)){ //페이지 간격 예외 확인
            result = false;
        }
        if(isEven(leftPageNumber) && isOdd(rightPageNumber)){ //페이제 홀수 짝수 예외 확인
            result = false;
        }
        return result;
    }

    public static boolean checkListSize(List<Integer> player){
        boolean result = true;
        if(player.size() != 2){
            result = false;
        }
        return result;
    }

    public static boolean checkPageNumberRange(int pageNumber){
        boolean result = true;
        if(pageNumber < MIN_PAGE || pageNumber > MAX_PAGE){
            result = false;
        }
        return result;
    }
    public static boolean checkInterval(int leftPageNumber, int rightPageNumber){
        boolean result = true;
        if(rightPageNumber - leftPageNumber != 1){
            result = false;
        }
        return result;
    }

    public static boolean isOdd(int pageNumber){
        boolean result = true;
        if(pageNumber % 2 == 0){
            result = false;
        }
        return result;
    }

    public static boolean isEven(int pageNumber){
        boolean result = true;
        if(pageNumber % 2 == 1){
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