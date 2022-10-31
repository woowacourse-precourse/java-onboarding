package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] ans = count_money(money);

        for (int i=0;i<9;i++){
            answer.add(ans[i]);
        }
        return answer;
    }

    //돈의 변환갯수를 계산해주는 함수
    static int[] count_money(int money) {
        int[] change = new int[9];
        int coin = 0;
        int start = 50000;

        for (int i=0;i<9;i++){
            if(zero_check(money/start)){
                change[i] = money/start;
                money = money-(change[i]*start);
                start = coin_change(i,start);

            }
            else{
                change[i] = 0;
                start = coin_change(i,start);
            }
        }

        return change;

    }
    //돈의 액수 반환값이 0인지 아닌지 판별해주는 함수
    static boolean zero_check(int change){
        if(change == 0){
            return false;
        }
        return true;
    }

    // 돈의 액수를 바꿔주는 함수
    static int coin_change(int i, int money){
        if(i==7) {
            return 1;
        }
        else if(i%2 == 0) {
            return money = money/5;
        }

        else if(i%2 == 1){
            return money = money/2;
        }

        return 0;
    }

}

