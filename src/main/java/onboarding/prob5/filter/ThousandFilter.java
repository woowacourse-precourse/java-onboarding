package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class ThousandFilter extends Filter{

    public ThousandFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.thousand.getValue();
        int remain = amount % Coin.thousand.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
