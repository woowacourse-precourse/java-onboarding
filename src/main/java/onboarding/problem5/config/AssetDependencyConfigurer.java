package onboarding.problem5.config;

import onboarding.problem5.AssetService;
import onboarding.problem5.koreanasset.AssetServiceImpl;
import onboarding.problem5.koreanasset.KoreanMoneyUnit;
import onboarding.problem5.MoneyUnit;

public class AssetDependencyConfigurer {

	private MoneyUnit moneyUnit;
	private AssetService assetService;

	public MoneyUnit koreanMoneyUnit() {
		if (moneyUnit == null) {
			return new KoreanMoneyUnit();
		}
		return moneyUnit;
	}

	public AssetService assetServiceImpl() {
		if (assetService == null) {
			return new AssetServiceImpl(koreanMoneyUnit());
		}
		return assetService;
	}
}
