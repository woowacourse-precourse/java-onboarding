package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {
    public static int getMyMax(int targetPage){
        int hundreds = targetPage % 100;
        int til_tens = targetPage-hundreds*100;
        int tens = til_tens % 10;
        int units = til_tens-tens*10;
        return Math.max(hundreds+tens+units,hundreds*tens*units);

    }
    public static boolean checkValidation(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (leftPage%2==0 || leftPage+1!=rightPage){
            return false;
        }
        else{
            return true;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}