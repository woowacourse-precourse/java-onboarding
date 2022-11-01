package onboarding.problem5.service;

import onboarding.problem5.utils.validator.NumberRangeValidator;
import onboarding.problem5.utils.validator.exception.NumberRangeException;
import onboarding.problem5.utils.KoreaMoneyUnit;
import java.util.ArrayList;
import java.util.List;

public class MoneyUnitCountService {

    public static List<Integer> getUnitCount(int money){
        List<Integer> unitCountList = new ArrayList<>();
        try{
            new NumberRangeValidator(money);
            countUnit(money, unitCountList);
        }catch (NumberRangeException e){
            e.printStackTrace();
        }
        return unitCountList;
    }

    public static void countUnit(int money, List<Integer> result){
        for(KoreaMoneyUnit unit: KoreaMoneyUnit.values()){
            result.add(money/unit.getUnit());
            money %= unit.getUnit();
        }
    }
}
