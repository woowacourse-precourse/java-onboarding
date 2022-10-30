package onboarding.problem5.result;

import onboarding.problem.ProblemResult;
import onboarding.problem5.domain.Wallet;

import java.util.List;
import java.util.stream.Collectors;

import static onboarding.problem5.domain.Money.DEFAULT_MONIES;

public class Problem5Result implements ProblemResult<List<Integer>> {

    private final Wallet wallet;

    public Problem5Result(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public List<Integer> toResult() {
        return DEFAULT_MONIES
                .stream()
                .map(wallet::get)
                .collect(Collectors.toList());
    }
}
