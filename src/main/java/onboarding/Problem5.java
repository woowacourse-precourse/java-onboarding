package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Exception;

class MoneyTransformation{
    int changes;
    final List<Integer> moneyVouchers=List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    MoneyTransformation(int money){
        changes=money;
    }
    void withdraw(int amount){
        changes-=amount;
    }
    int calculateAmount(int voucherCount, int moneyVoucher){
        return voucherCount*moneyVoucher;
    }
    int moneyVoucherCount(int money, int moneyVoucher){
        return money/moneyVoucher;
    }
    List<Integer> exchange(){
        int voucherCount;
        int amount;
        List<Integer> moneyVoucherCounts=new ArrayList<>();

        for (Integer voucher : moneyVouchers) {
            voucherCount = moneyVoucherCount(changes, voucher);
            moneyVoucherCounts.add(voucherCount);
            amount=calculateAmount(voucherCount, voucher);
            withdraw(amount);
        }
        return moneyVoucherCounts;
    }
}
class OverMoneyBounds extends Exception{
    OverMoneyBounds(String errorMessage){
        super(errorMessage);
    }
}
public class Problem5 {
    public static void checkMoneyBounds(int money) throws OverMoneyBounds{
        final int lowerBound=1;
        final int upperBound=1000000;
        if((lowerBound>=money||money>=upperBound)){
            throw new OverMoneyBounds("money 변수를 잘못 입력하셨습니다.");
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try {
            Problem5.checkMoneyBounds(money);

            MoneyTransformation moneyTransformation = new MoneyTransformation(money);
            answer=moneyTransformation.exchange();
        }catch (OverMoneyBounds e){
            System.out.println("에러 메세지: "+e.getMessage());
        }

        return answer;
    }
}
