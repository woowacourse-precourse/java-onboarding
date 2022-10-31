package onboarding;


import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(CheckInput(money)){
        }
        throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(int money){
        if(money > 0 && money < 1000001){
            return true;
        }return false;
    }
}
