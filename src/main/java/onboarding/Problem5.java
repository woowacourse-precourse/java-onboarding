package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = easyMoney(money);
        return answer;
    }

    public static ArrayList<Integer> easyMoney(int money) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (money != 0) {
            ans.add(moneyCount(money, 50000));
            money -= 50000 * moneyCount(money, 50000);

            ans.add(moneyCount(money, 10000));
            money -= 10000 * moneyCount(money, 10000);

            ans.add(moneyCount(money, 5000));
            money -= 5000 * moneyCount(money, 5000);

            ans.add(moneyCount(money, 1000));
            money -= 1000 * moneyCount(money, 1000);

            ans.add(moneyCount(money, 500));
            money -= 500 * moneyCount(money, 500);

            ans.add(moneyCount(money, 100));
            money -= 100 * moneyCount(money, 100);

            ans.add(moneyCount(money, 50));
            money -= 50 * moneyCount(money, 50);

            ans.add(moneyCount(money, 10));
            money -= 10 * moneyCount(money, 10);

            ans.add(moneyCount(money, 1));
            money -= ans.get(8);
        }
        return ans;
    }

    public static Integer moneyCount(int money, int easyMoney) //내가 가진 돈이 단위지폐 몇장으로 바꿀수 있는지 알려주는 함수
    {
        int cnt = 0;
        while (money >= easyMoney) {
            money -= easyMoney;
            cnt++;
        }
        return cnt;
    }
}

