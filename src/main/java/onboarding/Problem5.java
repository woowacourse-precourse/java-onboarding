package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
 * 지폐 단위 위치를 딴 곳으로 바꿔 볼까 생각하기 -> 성공
 * 이건 굳이 나눌 필요가 있을까? -> 나중에 10만원권 들어올 수도 있으니 나누자 -> 성공
 * 시간 줄이기 a를 없애보자 -> 성공
 * 코드는 간결해졌는데... 이게 맞나
 */
public class Problem5 {
    private static final List<Integer> denomination = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int bill : denomination){
            answer.add(money / bill);
            money %= bill;
        }
        return answer;
    }
}
