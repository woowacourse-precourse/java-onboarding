package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();    
        answer = new ArrayList<>();        
        int[] arrMoney = new int[9];        
        arrMoney[0] = money/50000; //50000
        arrMoney[1] = money%50000/10000; //10000
        arrMoney[2] = money%50000%10000/5000; //5000
        arrMoney[3] = money%50000%10000%5000/1000; //1000
        arrMoney[4] = money%50000%10000%5000%1000/500; //500
        arrMoney[5] = money%50000%10000%5000%1000%500/100; //100
        arrMoney[6] = money%50000%10000%5000%1000%500%100/50; //50
        arrMoney[7] = money%50000%10000%5000%1000%500%100%50/10; //10
        arrMoney[8] = money%50000%10000%5000%1000%500%100%50%10/1; //1
        for(int i=0; i<arrMoney.length; i++) {
        	answer.add(arrMoney[i]);
        }        
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
    	Problem5 p5 = new Problem5();
        int money = 50_237;
        System.out.println(p5.solution(money));
        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            
	}
}
