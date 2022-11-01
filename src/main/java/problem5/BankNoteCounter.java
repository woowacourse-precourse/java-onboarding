package problem5;

import java.util.ArrayList;
import java.util.List;

public class BankNoteCounter {

    // 지폐 계수기 기능 :: ClassCastException
    public static ArrayList<Integer> countBankNote(ArrayList<Integer> moneyRepository, int[] postMoney, int money){


        for (int i = 0; i< postMoney.length; i++){
            moneyRepository.add(money / postMoney[i]);
            money %= postMoney[i];
        }
        return moneyRepository;
    }
}
