package onboarding;
/*
 * 기능구현
 * 1. money 범위 파악 함수 생성
 * 2. Money 단위를 담는 배열 생성
 * 3. 나머지연산과 나누기 연산으로 몫 합산
 * */
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        Integer[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        if (money >= 1 && money < 1000000) {
            for (Integer integer : moneyList) {
                int c = money / integer;
                if (c > 0) {
                    answer.add(c);
                } else {
                    answer.add(0);
                }
                money %= integer;
            }
        }
        return answer;
    }
}
