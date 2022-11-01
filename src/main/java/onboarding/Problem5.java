package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        /*
        * 5만원권부터 1원 동전까지의 값이 들어있는 배열 생성
        * money를 위의 배열을 통해 for문으로 나눈뒤 0이 아닌 값이 나왔을 경우 money에서 값을 감산
        * money를 나눈 몫이 0인 경우 answer의 배열에 0을 추가하며 다음 루프로 이동
        * */
        return answer;
    }

    public static void main(String[] args) {
        int money = 15_000;
        System.out.println(solution(money));
    }
}
