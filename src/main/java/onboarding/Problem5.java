package onboarding;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import onboarding.problem5.Asset;
import onboarding.problem5.AssetService;
import onboarding.problem5.config.AssetDependencyConfigurer;

public class Problem5 {

    private static final AssetDependencyConfigurer assetConfig = new AssetDependencyConfigurer();


    public static List<Integer> solution(int money) {
        Asset asset = new Asset();
        AssetService assetService = assetConfig.assetServiceImpl();
        assetService.deposit(money, asset);

        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> unitsMap = assetService.withdrawAllAsCash(asset);

        Map<Integer, Integer> moneyUnitMap = getMoneyUnitMap(koreanMoneyUnits);

        for (int moneyUnit : koreanMoneyUnits) {
            exchangeToMoneyUnit(money, moneyUnit);
        }
        while (cursor < koreanMoneyUnits.length
                && money > 0) {
            int currentUnit = koreanMoneyUnits[cursor];
            if (money < currentUnit) {
                cursor += 1;
                continue;
            }

            money -= currentUnit;
            moneyUnitMap.put(currentUnit, moneyUnitMap.get(currentUnit) + 1);
        }

        for (Integer value : moneyUnitMap.values()) {
            answer.add(value);
        }

        return answer;
    }

    private static Map<Integer, Integer> getMoneyUnitMap(int[] moneyUnits) {
        Map<Integer, Integer> moneyUnitMap = new LinkedHashMap<>();
        for (int i = 0; i < moneyUnits.length; i++) {
            moneyUnitMap.put(moneyUnits[i], 0);
        }

        return moneyUnitMap;
    }

    private static void exchangeToMoneyUnit(int money, int moneyUnit) {

    }
}

