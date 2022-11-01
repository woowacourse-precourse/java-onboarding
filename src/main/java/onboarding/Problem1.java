package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(isValidInput(pobi) && isValidInput(crong))){
            return -1;
        }
        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);
        return gameResult(pobiScore,crongScore);
    }

    public static boolean isValidInput(List<Integer> input){
        if((input.get(1) - input.get(0)) == 1){
            return true;
        }
        return false;
    }

    public static int calculateScore(List<Integer> input){
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(0,0));
        for(int i = 0; i < 2; i++){
            int value = input.get(i);
            int sum = 0;
            int multiplication = 1;
            while(value > 0){
                int digit = value%10;
                sum += digit;
                multiplication *= digit;
                value = value/10;
            }
            values.set(i, Math.max(sum, multiplication));
        }
        return Collections.max(values);
    }

    public static int gameResult(int pobi, int crong){
        if(pobi > crong){
            return 1;
        }
        else if(pobi == crong){
            return 0;
        }
        else{
            return 2;
        }
    }
}