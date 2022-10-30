package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class HundredFilter extends Filter{

    public HundredFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.Hundred.getValue();
        int remain = amount % Coin.Hundred.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
