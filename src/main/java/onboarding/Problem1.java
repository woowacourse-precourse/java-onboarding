package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1)-pobi.get(0) != 1){
            return -1;
        }
        if (crong.get(1)-crong.get(0) != 1){
            return -1;
        }
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            return -1;
        }     
        
        int pobiScore1 = pobi.get(0).toString().chars().map(operand -> operand - '0').reduce(0, (left, right) -> {return left + right;});
        int pobiScore2 = pobi.get(0).toString().chars().map(operand -> operand - '0').reduce(1, (left, right) -> {return left * right;});
        int pobiScore3 = pobi.get(1).toString().chars().map(operand -> operand - '0').reduce(0, (left, right) -> {return left + right;});
        int pobiScore4 = pobi.get(1).toString().chars().map(operand -> operand - '0').reduce(1, (left, right) -> {return left * right;});
        
        int crongScore1 = crong.get(0).toString().chars().map(operand -> operand - '0').reduce(0, (left, right) -> {return left + right;});
        int crongScore2 = crong.get(0).toString().chars().map(operand -> operand - '0').reduce(1, (left, right) -> {return left * right;});
        int crongScore3 = crong.get(1).toString().chars().map(operand -> operand - '0').reduce(0, (left, right) -> {return left + right;});
        int crongScore4 = crong.get(1).toString().chars().map(operand -> operand - '0').reduce(1, (left, right) -> {return left * right;});
        
        int pobiScore = Collections.max(Arrays.asList(pobiScore1, pobiScore2, pobiScore3, pobiScore4));
        int crongScore = Collections.max(Arrays.asList(crongScore1, crongScore2, crongScore3, crongScore4));
        
        if (pobiScore > crongScore) {
            return 1;
        }
        else if (pobiScore < crongScore) {
            return 2;
        }
        else {
            return 0;
        }
    } 
}