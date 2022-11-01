package onboarding;

import onboarding.P5.AutomaticBank;
import onboarding.P5.NumberSizeVerification;
import onboarding.P5.UnitOfMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        NumberSizeVerification numberSizeVerification = new NumberSizeVerification();
        AutomaticBank automaticBank = new AutomaticBank();
        if(!numberSizeVerification.NumberCheck(money)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }

        return automaticBank.changemoney(money);

    }
}

