package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Problem5 problem5= new Problem5();
        answer = problem5.categorize(money);
        return answer;
    } //solution

    private List<Integer> categorize(int money){
       List<Integer> wallet = new ArrayList<Integer>();
       int[] moneyUnit = {1,10,50,100,500,1000,5000,10000,50000};
       
       for(int i = moneyUnit.length-1; i > -1 ; i--){
    	   if(i== moneyUnit.length-1)  {wallet.add((money)/moneyUnit[i]);continue;}
    	   wallet.add(money%(moneyUnit[i+1])/moneyUnit[i]);
       }//for
       return wallet;
    } // categorize
}// end class