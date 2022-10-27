package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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
}