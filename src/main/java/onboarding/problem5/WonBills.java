package onboarding.problem5;

import java.util.List;

public class WonBills {
    final int FIFTY_THOUSAND = 50_000;
    final int TEN_THOUSAND = 10_000;
    final int FIVE_THOUSAND = 5_000;
    final int ONE_THOUSAND = 1_000;
    final int FIVE_HUNDRED = 500;
    final int ONE_HUNDRED = 100;
    final int FIFTY = 50;
    final int TEN = 10;
    final int ONE = 1;

    private final List<Integer> bills = List.of(FIFTY_THOUSAND, TEN_THOUSAND, FIVE_THOUSAND, ONE_THOUSAND, FIVE_HUNDRED, ONE_HUNDRED, FIFTY, TEN, ONE);

    public List<Integer> getBills() {
        return bills;
    }
}
