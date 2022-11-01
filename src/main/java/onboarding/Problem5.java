package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if(money>1000000||money<0)return answer;
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for(int i=0;i<coin.length;i++){
            int cnt=0;
            while(true){
                if((money-coin[i])>=0){
                    System.out.print(money+"   ");
                    money = money-coin[i];
                    System.out.println(money);
                    cnt++;
                }
                else break;
            }
            answer.add(cnt);
        }
        answer.add(money);
        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(solution(50237));
//    }
}
