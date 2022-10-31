package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    //돈의 변환갯수를 계산해주는 함수

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

