package onboarding.prob5.domain;

import java.util.ArrayList;
import java.util.List;
import onboarding.prob5.filter.FiftyFilter;
import onboarding.prob5.filter.Filter;
import onboarding.prob5.filter.FiftyThousandFilter;
import onboarding.prob5.filter.FiveHundredFilter;
import onboarding.prob5.filter.FiveThousandFilter;
import onboarding.prob5.filter.HundredFilter;
import onboarding.prob5.filter.OneFilter;
import onboarding.prob5.filter.TenFilter;
import onboarding.prob5.filter.TenThousandFilter;
import onboarding.prob5.filter.ThousandFilter;

public class Banker {

    public List<Integer> solve(int money) {
        return getChanges(money);
    }

    final List<Integer> getChanges(int money) {
        List<Integer> changes = new ArrayList<>();
        Filter filter = getFilter();
        return filter.resolve(money, changes);
    }

    private Filter getFilter() {
        Filter filter = new FiftyThousandFilter(new TenThousandFilter(new FiveThousandFilter(new ThousandFilter(new FiveHundredFilter(new HundredFilter(new FiftyFilter(new TenFilter(new OneFilter(null)))))))));
        return filter;
    }
}
