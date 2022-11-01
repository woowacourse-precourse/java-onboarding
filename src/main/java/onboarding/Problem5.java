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

        Map<Integer, Integer> moneyUnitMap = assetService.withdrawAllAsCash(asset);

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

