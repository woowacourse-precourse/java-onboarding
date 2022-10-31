package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
