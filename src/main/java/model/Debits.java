package model;

import java.util.ArrayList;
import java.util.List;

public class Debits{
    private int money;

    public Debits(int money){
        this.money = money;
    }

    public List<Integer> getDebitsDetail(){
        List<Integer> debitsDetail = new ArrayList<>();
        initDebitsDetail(debitsDetail, 9);
        for (int i = 0; i < debitsDetail.size(); i++){
            int exchangeMoney = getExchangeMoney(i);
            int exchangeAmount = getExchangeAmount(exchangeMoney);
            debitsDetail.set(i, exchangeAmount);
        }

        return debitsDetail;
    }

    void initDebitsDetail(List<Integer> debitsDetail, int size){
        for (int i = 0; i < size; i++){
            debitsDetail.add(0);
        }
    }

    int getExchangeAmount(int exchangeMoney){
        int exchangeAmount = money / exchangeMoney;
        this.money -= exchangeMoney * exchangeAmount;
        return exchangeAmount;
    }

    int getExchangeMoney(int idx){
        switch (idx){
            case 0:
                return 50000;
            case 1:
                return 10000;
            case 2:
                return 5000;
            case 3:
                return 1000;
            case 4:
                return 500;
            case 5:
                return 100;
            case 6:
                return 50;
            case 7:
                return 10;
            case 8:
                return 1;
            default:
                return -1;
        }
    }

}
