package onboarding;

import java.util.List;

class Problem1 {

    public static Long multiply(Integer n){
        long sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    public static Long add(Integer n){
        long sum = n % 10;
        n /= 10;
        while (n > 0){
            sum *= n % 10;
            n /= 10;
        }
        return sum;
    }


    public static Long pickBigger(Integer left, Integer right){
        Long biggerLeft = Math.max(add(left), multiply(left));
        Long biggerRight = Math.max(add(right), multiply(right));

        return Math.max(biggerLeft, biggerRight);
    }

    public static Boolean checkException(List<Integer> pages){
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        if (left == 1 && right == 2) return false;
        else if(left == 399 && right == 400) return false;
        else if(right - left != 1) return false;
        else if(!(left % 2 == 1 && right %2 == 0)) return false;
        else return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(checkException(pobi) && checkException(crong)))
            return -1;

        Long pobiNum = pickBigger(pobi.get(0), pobi.get(1));
        Long crongNum = pickBigger(crong.get(0), crong.get(1));

        if (pobiNum > crongNum) return 1;
        if (pobiNum < crongNum) return 2;
        else return 0;
    }
}