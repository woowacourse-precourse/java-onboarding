package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 기능 목록 1 : 화폐 단위별 개수를 구하는 함수
    public static int numberOf(int money, int unit){
        int num;
        num = money/unit;

        return num;
    }

    // 기능 목록 2 : 남은 돈을 처리하는 함수
    public static int remainMoney(int money, int unit){
        int num;
        num = money%unit;

        return num;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
