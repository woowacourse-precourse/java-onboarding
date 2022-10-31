package onboarding;

import java.util.ArrayList;
import java.util.List;

//-----기능-----
//1. 지폐 배열 만들기
//2. 각 액수 마다 몇 장 필요한지 계산

public class Problem5 {

    public static List<Integer> solution(int money) {
        int[] bank = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int bankmoney: bank)
        {
            answer.add(money / bankmoney);
            money -= money / bankmoney * bankmoney;
        }

        return answer;
    }
}
