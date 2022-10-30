package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class FiveThousandFilter extends Filter{

    public FiveThousandFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.fiveThousand.getValue();
        int remain = amount % Coin.fiveThousand.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
