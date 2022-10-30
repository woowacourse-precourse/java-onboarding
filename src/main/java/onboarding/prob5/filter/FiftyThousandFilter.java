package onboarding.prob5.filter;

import java.util.List;
import onboarding.prob5.domain.Coin;

public class FiftyThousandFilter extends Filter{

    public FiftyThousandFilter(Filter filter) {
        super(filter);
    }


    @Override
    public List<Integer> resolve(int amount, List<Integer> changes) {
        int change = amount / Coin.fiftyThousand.getValue();
        int remain = amount % Coin.fiftyThousand.getValue();
        changes.add(change);
        return super.resolve(remain, changes);
    }
}
