package onboarding;

import java.util.Collections;
import java.util.List;
/*
*   구현 기능
*   1. 5만원권 세는 기능
*   2. 1만원권 세는 기능
*   3. 5천원권 세는 기능
*   4. 1천원권 세는 기능
*   5. 5백원권 세는 기능
*   6. 1백원권 세는 기능
*   7. 5십원권 세는 기능
*   8. 1십원권 세는 기능
*/
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        MoneyCounter moneyCounter = new MoneyCounter(money);
        answer = moneyCounter.getList();
        return answer;
    }
}

class MoneyCounter {
    private int money;

    public MoneyCounter(int money) {
        this.money = money;
    }

    public List<Integer> getList() {
        return List.of(fiveM(), oneM(), fiveT(), oneT(), fiveH(), oneH(), fifty(), ten(), money);
    }

    private int fiveM(){
        int count;
        count = money / 50000;
        money -= 50000 * count;
        return count;
    }

    private int oneM(){
        int count;
        count = money / 10000;
        money -= 10000 * count;
        return count;
    }

    private int fiveT(){
        int count;
        count = money / 5000;
        money -= 5000 * count;
        return count;
    }

    private int oneT(){
        int count;
        count = money / 1000;
        money -= 1000 * count;
        return count;
    }

    private int fiveH(){
        int count;
        count = money / 500;
        money -= 500 * count;
        return count;
    }

    private int oneH(){
        int count;
        count = money / 100;
        money -= 100 * count;
        return count;
    }

    private int fifty(){
        int count;
        count = money / 50;
        money -= 50 * count;
        return count;
    }

    private int ten(){
        int count;
        count = money / 10;
        money -= 10 * count;
        return count;
    }
}