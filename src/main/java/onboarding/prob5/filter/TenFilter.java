package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class TenFilter extends Filter{

    public TenFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.ten.getValue();
        int remain = amount % Coin.ten.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
