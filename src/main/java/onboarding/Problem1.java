package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxValue = 0, crongMaxValue = 0, digitdiff, answer;
        
        if(pobi.get(0) - pobi.get(1) != -1){
            answer = -1;
            return answer;
        }
        
        if(crong.get(0) - crong.get(1) != -1){
            answer = -1;
            return answer;
        }
        
        for (int i : pobi){
            int addedSum = 0, multipliedProduct = 1;
            for (int currentDigit; i != 0; i /=10){
                currentDigit = i % 10;
                addedSum += currentDigit;
                multipliedProduct *= currentDigit;
            }
            if (multipliedProduct >= addedSum){
                pobiMaxValue = multipliedProduct;
            }
            else {
                pobiMaxValue = addedSum;
            }
        }
    
        for (int i : crong){
            int addedSum = 0, multipliedProduct = 1;
            for (int currentDigit; i != 0; i /=10){
                currentDigit = i % 10;
                addedSum += currentDigit;
                multipliedProduct *= currentDigit;
            }
            if (multipliedProduct >= addedSum){
                crongMaxValue = multipliedProduct;
            }
            else {
                crongMaxValue = addedSum;
            }
        }
        
        if (crongMaxValue > pobiMaxValue){
            answer = 2;
        }
        if (crongMaxValue == pobiMaxValue){
            answer = 0;
        }
        else {
            answer = 1;
        }
        
        return answer;
    }
}