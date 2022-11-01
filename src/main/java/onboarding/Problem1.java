package onboarding;

import java.util.List;

class Problem1 {
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
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

        int leftMax = Math.max(leftSum, leftProduct);
        int rightMax = Math.max(rightSum, rightProduct);

        return Math.max(leftMax, rightMax);
    }

    public static boolean checkValidity(List<Integer> player){
        int leftPageNumber;
        int rightPageNumber;

        if(!checkListSize(player)){
            return false;
        }

        leftPageNumber = player.get(0);
        rightPageNumber = player.get(1);

        return checkPageNumberRange(leftPageNumber) && checkPageNumberRange(rightPageNumber)
                && checkInterval(leftPageNumber, rightPageNumber)
                && isOdd(leftPageNumber) && isEven(rightPageNumber);
    }

    public static boolean checkListSize(List<Integer> player){
        return (player.size() == 2);
    }

    public static boolean checkPageNumberRange(int pageNumber){
        return (pageNumber >= FIRST_PAGE && pageNumber <= LAST_PAGE);
    }
    public static boolean checkInterval(int leftPageNumber, int rightPageNumber){
        return (rightPageNumber - leftPageNumber == INTERVAL);
    }

    public static boolean isOdd(int pageNumber){
        return (pageNumber % 2 == 1);
    }

    public static boolean isEven(int pageNumber){
        return (pageNumber % 2 == 0);
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