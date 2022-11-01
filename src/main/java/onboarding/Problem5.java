package onboarding;
import java.util.ArrayList;
import java.util.List;
// 1. 단위를 int{}에 담고, 순서대로 몫을 확인: solution
// 2. 몫 확인: int count(int money, int unit)
// 3. 나머지 확인: int rest(int money, int unit)
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<unit.length; i++) {
            answer.add(count(money, unit[i]));
            money = rest(money, unit[i]);
        }

        return answer;
    }

    public static int count(int money, int unit) {
        return money / unit;
    }

    public static int rest(int money, int unit) {
        return money % unit;
    }
}