package onboarding.problem5.koreanasset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import onboarding.problem5.Asset;
import onboarding.problem5.AssetService;
import onboarding.problem5.MoneyUnit;

public class AssetServiceImpl implements AssetService {

	private final MoneyUnit moneyUnit;

	public AssetServiceImpl(MoneyUnit moneyUnit) {
		this.moneyUnit = moneyUnit;
	}

	public int deposit(int money, Asset asset) {
		asset.deposit(money);
		return asset.getAsset();
	}

	@Override
	public synchronized Map<Integer, Integer> withdrawAllAsCash(Asset asset) {
		int[] koreanMoneyUnits = moneyUnit.getMoneyUnits();
		int cursor = 0;

		Map<Integer, Integer> moneyUnitMap = getMoneyUnitMap();
		asset.lock();
		while (cursor < koreanMoneyUnits.length
			&& asset.getAsset() > 0) {
			int currentUnit = koreanMoneyUnits[cursor];
			if (asset.getAsset() < currentUnit) {
				cursor += 1;
				continue;
			}
			asset.withdraw(currentUnit);
			moneyUnitMap.put(currentUnit, moneyUnitMap.get(currentUnit) + 1);
		}
		asset.unlock();

		return moneyUnitMap;
	}

	private Map<Integer, Integer> getMoneyUnitMap() {
		Map<Integer, Integer> moneyUnitMap = new LinkedHashMap<>();
		int[] moneyUnits = moneyUnit.getMoneyUnits();
		for (int i = 0; i < moneyUnits.length; i++) {
			moneyUnitMap.put(moneyUnits[i], 0);
		}

		return moneyUnitMap;
	}
}
