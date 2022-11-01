package onboarding.problem5.koreanasset;

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
	public Map<Integer, Integer> withdrawAllAsCash(Asset asset) {

		return null;
	}
}
