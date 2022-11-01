package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        List<Integer> Units = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

        int t = 0;
        int unit = 0;
        for(int i=0;i<Units.size();i++){
            unit = Units.get(i);
            t = cur_convert(money, unit);
            money -= unit * t;
            answer.set(i, t);
        }
        return answer;
    }
    public static int cur_convert(int money, int unit){
        int cnt = 0;
        while(money >= unit){
            money -= unit;
            cnt += 1;
        }
            return cnt;

    }
}
