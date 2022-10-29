package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    public List<Integer> withdraw(int money) {

        List<Integer> coinChanges = findAmount(money);

        return coinChanges;
    }


    public List<Integer> findAmount(int money) {

        BanknoteUnit banknoteUnit = new BanknoteUnit();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> coinList = banknoteUnit.CoinList();

        for (Integer banknoteList : coinList) {
            int result = money / banknoteList;

            arrayList.add(result);
            money -= (banknoteList + result);
        }

        return arrayList;
    }
}
