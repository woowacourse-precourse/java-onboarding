package onboarding;

import java.util.ArrayList;
import java.util.List;
/**
 * 기능 요구사항
 * 1. 50000 ~ 1까지 단위를 정의해야 한다.
 * 2. 주어진 돈을 각 각의 단위로 몇 개씩 변환되는지 알 수 있어야 한다.
 */
public class Problem5 {
    static int [] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = convert(money);
        return answer;
    }

    private static ArrayList<Integer> convert(int money) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int unit : units){
            if(unit>money){
                result.add(0);
            }else{
                result.add(money / unit);
                money %= unit;
            }
        }
        return result;
    }
}
