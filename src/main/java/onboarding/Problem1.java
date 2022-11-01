package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int maxPobi = compareLeftRightPage(pobi);
        int maxCrong = compareLeftRightPage(crong);
        if (checkException(pobi) || checkException(crong)){
            return EXCEPTION;
        }
        return comparePobiCrong(maxPobi,maxCrong);
    }

    public static int plusnumber(String numbers){
        int number = 0;
        for(int i=0;i<numbers.length();i++){
            number += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return number;
    }

    public static int mulnumber(String numbers){
        int number = 1;
        for(int i=0;i<numbers.length();i++){
            number*=Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return number;
    }

    public static int compareLeftRightPage(List<Integer> listnum){
        int answer = 0;
        for(int number : listnum){
            answer = Math.max(answer,plusnumber(Integer.toString(number)));
            answer = Math.max(answer,mulnumber(Integer.toString(number)));
        }
        return answer;
    }

    public static int comparePobiCrong(int pobi,int crong){
        if (pobi > crong){
            return POBI_WIN;
        } else if (pobi < crong){
            return CRONG_WIN;
        } else{
            return DRAW;
        }
    }

    public static boolean checkException(List<Integer> numbers){
        if (numbers.get(1) - numbers.get(0) != 1){
            return true;
        }
        if (numbers.get(0)%2 != 1 || numbers.get(1)%2 != 0){
            return true;
        }
        for (int i:numbers){
            if (i<=1 || i>=400){
                return true;
            }
        }
        return false;
    }
}