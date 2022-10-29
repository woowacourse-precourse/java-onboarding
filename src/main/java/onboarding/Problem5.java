package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>(9);

        int copyMoney = money;
        int price = 50000;

        for(int i = 0; i<9; i++){
            if(i==0){
                answer.add(copyMoney/price);
                copyMoney = copyMoney % price;
            } else if (i%2==0) {
                if(price !=10){
                    price= price/2;
                }else{
                    price=price/10;
                }
                answer.add(copyMoney/price);
                copyMoney = copyMoney % price;
            }else{
                price= price/5;

                answer.add(copyMoney/price);
                copyMoney = copyMoney % price;
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(50237));
    }
}
