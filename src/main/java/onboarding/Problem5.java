package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Sol1: 큰 금액부터 나누어 몫을 리스트에 저장한다.

public class Problem5 {
    public static List<Integer> solution(int money){
        try{
            valid(money);
            List<Integer> answer = new ArrayList<>();
            Integer[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //지폐의 단위 배열을 만들어준다.

            for(int i = 0; i < amount.length; i++){ // 지폐의 큰 단위부터 나누어 몫을 저장한다.
                answer.add(money / amount[i]);
                money %= amount[i]; //나누고 난 나머지를 다시 money에 저장한다.
            }
            return answer;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static void valid(int money) throws Exception {
        if(money < 1 || money > 1000000){
            throw new Exception("입력받은 돈이 1이상 1,000,000이하의 자연수가 아닙니다."+money);
        }
    }
}
