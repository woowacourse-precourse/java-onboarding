package onboarding.problem5;

import java.util.Map;

public interface AssetService {
	int deposit(int money, Asset asset);

	Map<Integer, Integer> withdrawAllAsCash(Asset asset);

}
