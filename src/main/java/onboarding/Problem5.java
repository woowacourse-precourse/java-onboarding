package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5만원보다 값이 크다면 5만원을 빼고 count++ 하는 방식으로
 * while문을 돌려 가장작은 단위보다 작아질때까지 돌린다.
 * @author LG
 *
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        
        // 9개로 각각 변수를 선언한 후 마지막에 list에 다 add한다.
        int ohman = 0;
        int man = 0;
        int ohchan = 0;
        int chan = 0;
        int ohbaek = 0;
        int baek = 0;
        int ohship = 0;
        int ten = 0;
        int one = 0;
        
        // 0원이 될때까지 while문을 반복한다.
        while (money > 0) {
        	if (money >= 50000) {
        		money -= 50000;
        		ohman++;
        		continue;
        	} else if (money < 50000 && money >= 10000) {
        		money -= 10000;
        		man++;
        		continue;
        	} else if (money < 10000 && money >= 5000 ) {
        		money -= 5000;
        		ohchan++;
        		continue;
        	} else if (money < 5000 && money >= 1000) {
        		money -= 1000;
        		chan++;
        		continue;
        	}else if (money < 1000 && money >= 500) {
        		money -= 500;
        		ohbaek++;
        		continue;
        	}else if (money < 500 && money >= 100) {
        		money -= 100;
        		baek++;
        		continue;
        	}else if (money < 100 && money >= 50) {
        		ohship -= 50;
        		ohbaek++;
        		continue;
        	}else if (money < 50 && money >= 10) {
        		money -= 10;
        		ten++;
        		continue;
        	}else if (money < 10 && money >= 1) {
        		money -= 1;
        		one++;
        		continue;
        	}
        }
        
        answer.add(ohman);
        answer.add(man);
        answer.add(ohchan);
        answer.add(chan);
        answer.add(ohbaek);
        answer.add(baek);
        answer.add(ohship);
        answer.add(ten);
        answer.add(one);
       
        return answer;
        
    }
    
//    public static void main(String[] args) {
//		System.out.println(solution(15000));
//	}
}
