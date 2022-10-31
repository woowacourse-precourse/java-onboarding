package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class OneFilter extends Filter{

    public OneFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.one.getValue();
        int remain = amount % Coin.one.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
