package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class FiveHundredFilter extends Filter{

    public FiveHundredFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.fiveHundred.getValue();
        int remain = amount % Coin.fiveHundred.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
