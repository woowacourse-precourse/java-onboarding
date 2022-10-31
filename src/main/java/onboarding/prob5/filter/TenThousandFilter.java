package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class TenThousandFilter extends Filter{

    public TenThousandFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.tenThousand.getValue();
        int remain = amount % Coin.tenThousand.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
