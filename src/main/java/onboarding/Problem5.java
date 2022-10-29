package onboarding;

import java.util.ArrayList;
import java.util.List;

//-----기능-----
//1. 지폐 배열 만들기
//2. 각 액수 마다 몇 장 필요한지 계산

public class Problem5 {

    private static int calPaper(int bankmoney, int money) {
        int cnt = 0;
        while (true){
            if (money - bankmoney < 0)
                break;
            cnt++;
            money -= bankmoney;
        }

        return cnt;
    }

    public static List<Integer> solution(int money) {
        int bank[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int bankmoney: bank)
        {
            int num = calPaper(bankmoney, money);
            money -= num * bankmoney;
            answer.add(num);
        }
        return answer;
    }
}
