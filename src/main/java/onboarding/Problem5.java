package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
    	
        List<Integer> answer = new ArrayList<Integer>();
        
         /*
         * 5만원
         * 1만원
         * 5000원
         * 1000원
         * 500원
         * 100원
         * 50원
         * 10원
         * 1원
         * 
         * */
        //50000원으로 나누어떨어지면
        if(money / 50000 > 0) {
        	//몫 = 50000원권 개수 answer에 추가
        	answer.add(money / 50000);
        	//나머지 = 50000원권으로 바꾸고 남은 돈
        	money = money % 50000;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 50000);
		}
        
        
        //10000원으로 나누어떨어지면
        if(money / 10000 > 0) {
        	//몫 = 10000원권 개수 answer에 추가
        	answer.add(money / 10000);
        	//나머지 = 10000원권으로 바꾸고 남은 돈
        	money = money % 10000;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 10000);
		}
        
        //5000원으로 나누어떨어지면
        if(money /5000 > 0) {
        	//몫 = 5000원권 개수 answer에 추가
        	answer.add(money / 5000);
        	//나머지 = 5000원권으로 바꾸고 남은 돈
        	money = money % 5000;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 5000);
		}
        
        //1000원으로 나누어떨어지면
        if(money / 1000 > 0) {
        	//몫 = 1000원권 개수 answer에 추가
        	answer.add(money / 1000);
        	//나머지 = 1000원권으로 바꾸고 남은 돈
        	money = money % 1000;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 1000);
		}
        
        //500원으로 나누어떨어지면
        if(money / 500 > 0) {
        	//몫 = 500원권 개수 answer에 추가
        	answer.add(money / 500);
        	//나머지 = 500원권으로 바꾸고 남은 돈
        	money = money % 500;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 500);
		}
        
        //100원으로 나누어떨어지면
        if(money / 100 > 0) {
        	//몫 = 100원권 개수 answer에 추가
        	answer.add(money / 100);
        	//나머지 = 100원권으로 바꾸고 남은 돈
        	money = money % 100;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 100);
		}
        
        //50원으로 나누어떨어지면
        if(money / 50 > 0) {
        	//몫 = 50원권 개수 answer에 추가
        	answer.add(money / 50);
        	//나머지 = 50원권으로 바꾸고 남은 돈
        	money = money % 50;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 50);
		}
        
      //10원으로 나누어떨어지면
        if(money / 10 > 0) {
        	//몫 = 10원권 개수 answer에 추가
        	answer.add(money / 10);
        	//나머지 = 10원권으로 바꾸고 남은 돈
        	money = money % 10;
        }else {
        	//나누어 떨어지지 않으므로 0개 answer에 추가
        	answer.add(money / 10);
		}
        
        //남은값 1원 개수 answer에 추가
        answer.add(money / 1);
        
        
        return answer;
    }
}
