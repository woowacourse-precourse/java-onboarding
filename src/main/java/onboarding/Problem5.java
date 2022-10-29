package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
        return answer;
    }
    public static int CountJang(int unit,int money){
        int jang;
        jang=money/unit;
        return jang;
    }
    public static int currentmoney(int unit,int money){
        int currentmoney=money%unit;
        return currentmoney;
    }
}
