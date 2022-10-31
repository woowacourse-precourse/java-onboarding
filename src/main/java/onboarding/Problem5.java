package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static int[] numbers = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i< numbers.length; i++){
            int count = getOrder(money, i);
            answer.add(count);
            money -= count* numbers[i];
        }
        return answer;
    }


    private static int getOrder(int money, int idx){
        return money / numbers[idx];
    }
}